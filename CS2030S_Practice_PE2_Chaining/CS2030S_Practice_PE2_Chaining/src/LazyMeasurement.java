import cs2030s.fp.Combiner;
import cs2030s.fp.Lazy;
import cs2030s.fp.Producer;
import cs2030s.fp.Transformer;

public final class LazyMeasurement {
  private final Lazy<Double> value;

  public LazyMeasurement(Producer<? extends Double> producer) {
    // TODO
    this.value = null;
  }

  public double get() {
    // TODO
    return 0.0;
  }

  public LazyMeasurement map(
      Transformer<? super Double, ? extends Double> mapper) {
    // TODO
    return this;
  }

  public LazyMeasurement combine(
      LazyMeasurement other,
      Combiner<? super Double, ? super Double, ? extends Double> combiner) {
    // TODO
    return this;
  }

  public Lazy<Boolean> isWithin(double lower, double upper) {
    // TODO
    return Lazy.of(false);
  }

  @Override
  public String toString() {
    return this.value.toString();
  }
}
