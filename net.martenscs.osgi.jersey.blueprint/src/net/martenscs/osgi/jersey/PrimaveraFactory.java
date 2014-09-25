package net.martenscs.osgi.jersey;

interface GenericFactory<T, U> {
	T getObject();

	T getObject(U value);
}

public class PrimaveraFactory implements GenericFactory<Product<String>, String> {

	public Product<String> getObject() {
		return new Primavera();
	}

	public Product<String> getObject(String value) {
		Primavera res = new Primavera();
		res.setId(value);
		return res;
	}
}
