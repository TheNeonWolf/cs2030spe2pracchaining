# CS2030S Practice PE — Tasks

**Total: 25 marks | Suggested time: 100 minutes**

This paper is designed to practise more involved method chaining than the previous exercise.

---

## Task 1 — Lazy Measurement [5 marks]

Complete `LazyMeasurement`.

It stores a `Lazy<Double>` representing a measurement that may be expensive to compute.

Implement:

1. `get()` — evaluate and return the measurement. The producer must be evaluated at most once.
2. `map(Transformer<? super Double, ? extends Double> mapper)` — return a new `LazyMeasurement` whose value is transformed lazily.
3. `combine(LazyMeasurement other, Combiner<? super Double, ? super Double, ? extends Double> combiner)` — return a new `LazyMeasurement` combining the two measurements lazily.
4. `isWithin(double lower, double upper)` — return a `Lazy<Boolean>` that checks whether the measurement is within the inclusive range. The check must remain lazy.

Do not force a value in `map`, `combine`, or `isWithin`.

---

## Task 2 — Immutable Device [5 marks]

Complete `Device`.

A device has exactly three fields: `id` (`String`), `reading` (`double`), and `action` (`DeviceAction<Double>`).

Implement the constructor, accessors, and methods:

1. `performAction()` — return the result of the stored action.
2. `withReading(double newReading)` — return a new device with the same ID and action but the supplied reading.
3. `withAction(DeviceAction<Double> newAction)` — return a new device with the same ID and reading but the supplied action.
4. `calibrate(Calibration calibration)` — apply the supplied calibration and return its result.

The class must be immutable. Do not modify the original device. Use `final` fields and make the class `final`.

---

## Task 3 — Functional DeviceLog [7 marks]

Complete `DeviceLog<T extends Device>`.

It stores an `InfiniteList<T>`.

Implement:

1. `add(T device)` — return a **new** `DeviceLog<T>` with the device added at the end. Do not mutate the current log and do not use `append()`.
2. `removeById(String id)` — return a new log with **all** devices whose IDs equal `id` removed.
3. `mapReadings(Transformer<? super Double, ? extends Double> mapper)` — return a new `DeviceLog<Device>` where each device has its reading transformed, while preserving each device's ID and action.
4. `totalReading()` — return the sum of all readings. An empty log returns `0.0`.
5. `performAll()` — return the sum of all device action results. An empty log returns `0.0`.

Use `map`, `filter`, `reduce`, and `flatMap` where appropriate. The list operations must not mutate the original log.

---

## Task 4 — DeviceLogAnalytics [8 marks]

Complete the static methods in `DeviceLogAnalytics`.

1. `highest(DeviceLog<Device> log)`  
   Return a `Maybe<Device>` containing the device with the highest reading. If the log is empty, return an empty `Maybe`. If multiple devices tie, retain the **first** one.

2. `findById(DeviceLog<Device> log, String id)`  
   Return a `Maybe<Device>` containing the first device with the matching ID, or an empty `Maybe` if none exists.

3. `calibrateAll(DeviceLog<Device> log, InfiniteList<Calibration> calibrations)`  
   For each device, apply every calibration in encounter order. Return a new log containing the calibrated devices. The original log and devices must remain unchanged.

4. `highestAfterCalibration(DeviceLog<Device> log, InfiniteList<Calibration> calibrations)`  
   Calibrate every device, then return the highest-reading calibrated device as a `Maybe`. Preserve first-in-a-tie behaviour. Do not duplicate calibration logic; call your own `calibrateAll` and `highest` methods.

**Important:** Assume the calibration list is finite. The device log may be empty.

---

## General constraints

- No loops, arrays, `if`, `?:`, Java `Optional`, or Java Streams.
- Do not add extra fields or public methods.
- Do not change method signatures.
- `InfiniteList.append()` is not public.
- Use functional method chaining rather than imperative mutation.
