# Example script collection for ImageJ

[![Travis CI](https://travis-ci.org/imagej/example-script-collection.svg?branch=master)](https://travis-ci.org/imagej/example-script-collection)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/facf0eb976f44461af81d4469d597c0d)](https://www.codacy.com/app/imagejan/example-script-collection?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=imagej/example-script-collection&amp;utm_campaign=Badge_Grade)

This repository illustrates how to manage several ImageJ scripts in a collection.

---

Note that to make scripts available as menu commands in ImageJ, it is sufficient to put the script files into a _subfolder_ of `ImageJ.app/scripts/`, and to make them available to others, it is sufficient to upload the script files to an update site.

---

Keeping script files in a collection like this one adds the following benefits:

* *Dependency* management with Maven
* *Versioned* deployment using Git, Maven, and Travis CI
* Optionally: keep your scripts functional by running *Java unit tests* with every build

## How to use

1. Make a copy of this repository.
1. Delete `src/test/java` if you don't require tests.
1. Put your scripts into a *subfolder* of `src/main/resources/scripts` (the name of the subfolder[s] corresponds to the menu[s] where the commands will appear).
1. Edit `pom.xml` to reflect your project information.
1. Run `mvn` to build your jar file, or `mvn -Dimagej.app.directory=/path/to/your/ImageJ.app` to directly copy the jar file and possible dependencies into your ImageJ/Fiji installation.

## Questions

Please ask on the [ImageJ forum](http://forum.imagej.net/).
