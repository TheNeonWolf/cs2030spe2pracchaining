import cs2030s.fp.InfiniteList;
import cs2030s.fp.Transformer;

public final class DeviceLog<T extends Device> {
  private final InfiniteList<T> devices;

  public DeviceLog(InfiniteList<T> devices) {
    this.devices = devices;
  }

  public InfiniteList<T> getDevices() {
    return this.devices;
  }

  public DeviceLog<T> add(T device) {
    // TODO
    return this;
  }

  public DeviceLog<T> removeById(String id) {
    // TODO
    return this;
  }

  public DeviceLog<Device> mapReadings(
      Transformer<? super Double, ? extends Double> mapper) {
    // TODO
    return new DeviceLog<>(this.devices.map(
        device -> device.withReading(mapper.transform(device.getReading()))));
  }

  public double totalReading() {
    // TODO
    return 0.0;
  }

  public double performAll() {
    // TODO
    return 0.0;
  }

  @Override
  public String toString() {
    return this.devices.reduce("", (acc, device) ->
        acc + (acc.isEmpty() ? "" : ",") + device.toString());
  }
}
