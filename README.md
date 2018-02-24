# Custom View Testing

Custom views sometimes they contain logic that is hard to test. This is an
example of an added layer of abstraction on top of a (rather simple) custom view. In this case
the custom view becomes an independent entity which can in theory be placed in any `Activity` or
`Fragment` and live and fulfill it's destiny.

This repository shows how to implement a simple custom view with testing in mind, write both
unit and UI tests, and execute them.

## Structure

The example implements a *very basic* MVP set up with dependency injection (via `Dagger`). The
point of this repository is neither on MVP itself nor on dependency injection, thus the examples
are kept really simple to avoid adding bloat.

`AccountView` is a custom view that is capable of displaying an avatar, a notification badge and
a text. The view implements the `AccountViewContract.View` interface, which defines all entry
points to change the state of the view within the business logic.

`AccountViewPresenter` implements `AccountViewContract.Presenter` - in this case the presenter
is really dumb, the only thing it reacts to is `onViewAttached` which triggers an update of the
current state from an attached `AccountDataSource`. The fetched `Account` object is then processed
and the respective functions are invoked on the view.

The application contains two flavors: `prod` and `mock` - the purpose of this is to add a new
`source set` to the mock flavor which will contain the `MockActivity` as well as an
`AndroidManifest.xml` (in case you need to add permissions to save logs or screenshots) and
layout files for the different mock scenarios.

The `MockActivity` is kept pretty simple, it has a public variable for the layout, which is
set as content view in the `onCreate` method. That's it. The view is supposed to do the rest.

## Testing

The repository shows two different ways to test this feature. Unit tests and UI tests. Unit tests
are in general fast to write and fast to execute, whereas UI tests take more time to be developed
and more time to be executed. The unit tests in this repository are kept as verbose as possible.
Each unit test has a single responsibility, which makes it easy to spot failures of specific parts
of the application later on.


### Unit Tests

The presenter contains our business logic. It is also completely independent from the Android SDK
which allows us to execute unit tests via standard JUnit to verify its behavior.

The unit tests for the view are located in `/app/src/test/java/com/.../AccountViewPresenterTest.kt`.
They are based on JUnit and Mockito (plus a Mockito-Kotlin connector). Entry points into the
presenter (the `AccountDataSource`) and exit points into the view (`AccountViewContract.View`) are
mocked.

### UI Tests

UI testing is done via `espresso`. The UI tests are located in
`/app/src/androidTest/.../AccountViewTest.kt`. For the `AccountView` there is a new layout file
in the `mock` source set (`mock_view_account.xml`) which contains the view that's going to be
tested.

Before starting the `Activity` with the `ActivityTestRule` the mocked data source is prepared to
return a data state that is reflecting the current test situation.

## Execution

Unit tests: `./gradlew test` (the unit tests can be executed on any flavor)

UI tests: `./gradlew connectedMockDebugAndroidTest` (the UI tests have to be executed on the mock
flavor, since only this flavor contains our mocked data sources)

## License

This software is released under the [Apache License v2](https://www.apache.org/licenses/LICENSE-2.0).

## Copyright

Copyright 2018 Damian Burke
