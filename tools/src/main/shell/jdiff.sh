#!/bin/sh

# -----------------------------------------------
# Generates HTML pages for API changes.
#
# See http://www.geoapi.org/tools/index.html
# -----------------------------------------------

# Instruct bash to stop the script on error,
# or if an environment variable is not defined.
set -o errexit
set -o nounset

#
# This script needs to be run from the "resources/jdiff" directory
# containing the "GeoAPI-*.xml" files.
#
cd `dirname $0`
source ./setenv.sh
cd resources/jdiff

#
# The GeoAPI versions to be compared. The OLD_NAME and NEW_NAME values
# will be used both as titles in JDiff report, and as filenames of XML
# files describing the old and new API. Names can not contain spaces.
#
export OLD_NAME=GeoAPI-3.0.0
export NEW_NAME=GeoAPI-$GEOAPI_VERSION
export OLD_URL=http://www.geoapi.org/3.0/javadoc/
export NEW_URL=http://www.geoapi.org/snapshot/javadoc/

#
# Paths to binaries and source code. Those paths are built dynamically from
# the location of this "jdiff.sh" shell script,  and assuming a local Maven
# repository located at the standard place.
#
export GEOAPI_HOME=../../../../../..
export SOURCE_PATH=$GEOAPI_HOME/geoapi/src/main/java
export TARGET_PATH=$GEOAPI_HOME/geoapi/target
export CHANGES_API=$GEOAPI_HOME/target/site/changes/snapshot
export CHANGES_DOC=$GEOAPI_HOME/target/site/changes/document
export CLASSPATH=$TARGET_PATH/classes:$MAVEN_REPOSITORY/javax/measure/jsr-275/$JSR275_VERSION/jsr-275-$JSR275_VERSION.jar

#
# Generate a XML file containing API information.
# The "-apiname" option is specific to the JDiff doclet.
#
javadoc -docletpath ../../libraries/jdiff.jar -doclet jdiff.JDiff -apiname $NEW_NAME \
    -encoding UTF-8 -sourcepath $SOURCE_PATH -subpackages org.opengis \

#
# Remove the @author, @version, @since, @see and other javadoc tags.
# We don't want to report changes in those tags, or formatting changes.
#
java -classpath $GEOAPI_HOME/tools/target/classes org.opengis.tools.console.JDiffPostProcessing "$NEW_NAME.xml"

#
# JDiff is bundled with the "xerces.jar" XML parser, but we will ignore it.
# Instead, we will use the XML parser provided with Sun JDK. This parser is
# specified by the -Dorg.xml.sax.driver=... property. The driver class name
# can be obtained by:
#
# System.out.println(org.xml.sax.helpers.XMLReaderFactory.createXMLReader());
#
# The path to UML.java is declared because Javadoc needs at least one class,
# but is not used by the JDiff doclet.
#
mkdir -p $CHANGES_API
javadoc -docletpath ../../libraries/jdiff.jar -doclet jdiff.JDiff \
    -J-Dorg.xml.sax.driver=com.sun.org.apache.xerces.internal.parsers.SAXParser \
    -oldapi "$OLD_NAME" -javadocold $OLD_URL \
    -newapi "$NEW_NAME" -javadocnew $NEW_URL \
    -d $CHANGES_API -encoding UTF-8 $SOURCE_PATH/org/opengis/annotation/UML.java

mkdir -p $CHANGES_DOC
javadoc -docletpath ../../libraries/jdiff.jar -doclet jdiff.JDiff -docchanges \
    -J-Dorg.xml.sax.driver=com.sun.org.apache.xerces.internal.parsers.SAXParser \
    -oldapi "$OLD_NAME" -javadocold $OLD_URL \
    -newapi "$NEW_NAME" -javadocnew $NEW_URL \
    -d $CHANGES_DOC -encoding UTF-8 $SOURCE_PATH/org/opengis/annotation/UML.java

#
# Fix broken HTML and remove useless files.
#
cd $GEOAPI_HOME/target/site/changes
find . -name "*.html" -print | xargs sed --in-place='' "s/lEsS_tHaN/&lt;/g"
find . -name "*.html" -print | xargs sed --in-place='' "s/aNd_cHaR/&amp;/g"
find . -name "*.html" -print | xargs sed --in-place='' "s/quote_cHaR/&quot;/g"
find . -name "missingSinces.txt"  -delete
find . -name "user_comments*.xml" -delete
