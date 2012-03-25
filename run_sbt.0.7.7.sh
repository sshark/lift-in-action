#!/bin/sh
java -XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=1024m -Xmx2048M -Xss4M -jar `dirname $0`/tools/sbt-launch-0.7.7.jar "$@"
