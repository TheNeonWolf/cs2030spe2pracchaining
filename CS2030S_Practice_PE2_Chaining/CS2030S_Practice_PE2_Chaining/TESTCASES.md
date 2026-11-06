# Test Cases

Run JShell with the CS2030S library and the compiled `src` classes on the classpath. The exact launch command depends on your course setup.

```java
import cs2030s.fp.*;
```

## Task 1 — LazyMeasurement

```java
int[] calls = {0};
LazyMeasurement m = new LazyMeasurement(() -> {
  calls[0]++;
  return 12.0;
});
m.toString();          // should display ? (not evaluated)
calls[0];              // 0
m.get();               // 12.0
m.get();               // 12.0
calls[0];              // 1

LazyMeasurement doubled = m.map(x -> x * 2.0);
doubled.toString();    // ? (still lazy)
doubled.get();         // 24.0

LazyMeasurement other = new LazyMeasurement(() -> 3.0);
m.combine(other, (x, y) -> x + y).get();  // 15.0

m.isWithin(10.0, 15.0).get();             // true
m.isWithin(13.0, 20.0).get();             // false
```

Checks: single evaluation, lazy transformations, inclusive range boundaries.

## Task 2 — Immutable Device

```java
Device d = new Device("D1", 10.0, () -> 7.0);
d.getId();                         // "D1"
d.getReading();                    // 10.0
d.performAction();                 // 7.0

Device changed = d.withReading(15.0);
changed.toString();                // "D1:15.0"
d.toString();                      // "D1:10.0" (original unchanged)

Device changedAction = d.withAction(() -> 99.0);
changedAction.performAction();     // 99.0
d.performAction();                 // 7.0

Calibration addFive = sensor ->
    sensor.withReading(sensor.getReading() + 5.0);
d.calibrate(addFive).getReading(); // 15.0
d.getReading();                    // 10.0
```

## Task 3 — DeviceLog

```java
Device a = new Device("A", 10.0, () -> 1.0);
Device b = new Device("B", 20.0, () -> 2.0);
Device a2 = new Device("A", 30.0, () -> 3.0);

DeviceLog<Device> log =
    new DeviceLog<>(InfiniteList.of(a, b));

DeviceLog<Device> added = log.add(a2);
added.toString();                  // A:10.0,B:20.0,A:30.0
log.toString();                    // A:10.0,B:20.0 (original unchanged)

added.removeById("A").toString();  // B:20.0 (removes every A)
added.mapReadings(x -> x + 100.0).toString();
// A:110.0,B:120.0,A:130.0

added.totalReading();              // 60.0
added.performAll();                // 6.0

new DeviceLog<Device>(InfiniteList.of()).totalReading(); // 0.0
new DeviceLog<Device>(InfiniteList.of()).performAll();   // 0.0
```

## Task 4 — DeviceLogAnalytics

```java
Device a = new Device("A", 10.0, () -> 1.0);
Device b = new Device("B", 20.0, () -> 2.0);
Device c = new Device("C", 20.0, () -> 3.0);
DeviceLog<Device> log =
    new DeviceLog<>(InfiniteList.of(a, b, c));

DeviceLogAnalytics.highest(log).get().getId(); // "B" (first tie)
DeviceLogAnalytics.findById(log, "C").get().getReading(); // 20.0
DeviceLogAnalytics.findById(log, "X"); // empty Maybe

Calibration timesTwo =
    device -> device.withReading(device.getReading() * 2.0);
Calibration plusThree =
    device -> device.withReading(device.getReading() + 3.0);

DeviceLog<Device> calibrated = DeviceLogAnalytics.calibrateAll(
    log, InfiniteList.of(timesTwo, plusThree));

calibrated.toString();             // A:23.0,B:43.0,C:43.0
log.toString();                    // A:10.0,B:20.0,C:20.0 (unchanged)

DeviceLogAnalytics.highestAfterCalibration(
    log, InfiniteList.of(timesTwo, plusThree)).get().getId(); // "B"
```

Empty log:

```java
DeviceLog<Device> empty =
    new DeviceLog<>(InfiniteList.of());
DeviceLogAnalytics.highest(empty); // empty Maybe
DeviceLogAnalytics.findById(empty, "A"); // empty Maybe
DeviceLogAnalytics.highestAfterCalibration(
    empty, InfiniteList.of(timesTwo, plusThree)); // empty Maybe
```

Note: if your course `Maybe` uses a different method name for creating or inspecting an empty value, use the equivalent method from your local `Maybe.java`.
