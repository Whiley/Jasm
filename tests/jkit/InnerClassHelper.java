public class InnerClassHelper {

	public static class Helper1<T extends Number> {
		private T t;
		public Helper1(T t) {
			this.t = t;
		}
		
		public T get() { return t; }
	}
}
