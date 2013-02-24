# Background

The goal of this project is to convert a simple Java stopwatch to an
Android application.  The original java code can be found
[here](https://github.com/concurrency-cs-luc-edu/simplestopwatch-java).

# Learning Objectives

* Simple dependency injection
* Event-driven program execution
* Modeling state-dependent behavior with state machine diagrams
* Distinguishing between view states and model states
* Implementing state-dependent behavior using the State pattern
* Mapping the model-view-adapter architecture to Android
* Fa&ccedil;ade pattern for hiding complexity in the model from the adapter
* Distinguishing among dumb, reactive, and autonomous model components
* Background timers
* Concurrency issues: updating the view in the GUI thread

# Running the Application

* Android: as usual through Eclipse

# Running the Tests

To run the tests through Eclipse, make sure you have both this test
project and the subject-under-test (original project) open in the
current workspace.

* Test of various components with JUnit: in the test project, right-click on `src/edu...model` > Run As... > JUnit Test
  (if prompted for configuration-specific options, choose the Android JUnit test runner)
* Test of the activity in the Android emulator: right-click on the test project root > Run As... > Android JUnit Test

# TODO

* Robolectric testing
