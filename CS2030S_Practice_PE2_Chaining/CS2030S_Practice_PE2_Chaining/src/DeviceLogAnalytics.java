import cs2030s.fp.InfiniteList;
import cs2030s.fp.Maybe;

public final class DeviceLogAnalytics {
  private DeviceLogAnalytics() {
  }

  public static Maybe<Device> highest(DeviceLog<Device> log) {
    // TODO
    return Maybe.none();
  }

  public static Maybe<Device> findById(DeviceLog<Device> log, String id) {
    // TODO
    return Maybe.none();
  }

  public static DeviceLog<Device> calibrateAll(
      DeviceLog<Device> log, InfiniteList<Calibration> calibrations) {
    // TODO
    return log;
  }

  public static Maybe<Device> highestAfterCalibration(
      DeviceLog<Device> log, InfiniteList<Calibration> calibrations) {
    // TODO
    return Maybe.none();
  }
}
