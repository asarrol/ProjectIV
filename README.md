# Background

The goal of this project is to convert a simple Java stopwatch to an
Android application.  The original java code can be found
[here](https://github.com/concurrency-cs-luc-edu/simplestopwatch-java).

# Learning Objectives

* Simple dependency injection
* Event-driven program execution
* Modeling state-dependent behavior with state machine diagrams (see also [here](/loyolachicagocs_comp313/stopwatch-android-java/src/default/doc))
* Distinguishing between view states and model states
* Implementing state-dependent behavior using the State pattern
* Mapping the model-view-adapter architecture to Android
* Façade pattern for hiding complexity in the model from the adapter
* Distinguishing among dumb, reactive, and autonomous model components
* Package-level architecture and dependencies (see also [here](/loyolachicagocs_comp313/stopwatch-android-java/src/default/doc))
* Background timers
* Concurrency issues: updating the view in the GUI thread

# Setting up the Environment

Check out the project using Android Studio. This creates the `local.properties` file
with the required line

    sdk.dir=<root folder of Android Studio's Android SDK installation>

# Running the Application

In Android Studio: `Run > Run Stopwatch`

# Running the Tests

## Unit tests including out-of-emulator system tests using Robolectric

    $ gradle --info unitTest

## Android instrumentation tests (in-emulator/device system tests)

In Android Studio, right-click on `Stopwatch/src/instrumentTest/java/.../StopwatchActivityTest`,
then choose `Run StopwatchActivityTest`
