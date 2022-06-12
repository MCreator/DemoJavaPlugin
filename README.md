# Demo MCreator Java plugin

[![License](https://img.shields.io/badge/License-MIT-blue.svg)](https://github.com/MCreatpr/net.mcreator.demojavaplugin.DemoJavaPlugin/blob/master/LICENSE)

This repository demonstrates a basic MCreator Java plugin structure. 
Java plugins only work with MCreator 2022.2 or newer.

# Setup

In order for the plugin to work, make new file called `gradle.properties` with the following contents:

```
mcreator_path=<path to MCreator install directory>

```

# Gradle tasks
This demo plugin comes with some Gradle tasks to help you with the development of your plugin. 

* `runMCreatorWithPlugin`: Run MCreator with the plugin loaded

# Exporting
To export the plugin, run `jar` task and find the plugin zip file in `build/libs`.