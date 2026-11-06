public final class Device {
  private final String id;
  private final double reading;
  private final DeviceAction<Double> action;

  public Device(String id, double reading, DeviceAction<Double> action) {
    // TODO
    this.id = id;
    this.reading = reading;
    this.action = action;
  }

  public String getId() {
    return this.id;
  }

  public double getReading() {
    return this.reading;
  }

  public DeviceAction<Double> getAction() {
    return this.action;
  }

  public double performAction() {
    // TODO
    return 0.0;
  }

  public Device withReading(double newReading) {
    // TODO
    return this;
  }

  public Device withAction(DeviceAction<Double> newAction) {
    // TODO
    return this;
  }

  public Device calibrate(Calibration calibration) {
    // TODO
    return this;
  }

  @Override
  public String toString() {
    return this.id + ":" + this.reading;
  }
}
