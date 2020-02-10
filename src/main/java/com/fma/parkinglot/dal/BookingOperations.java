package com.fma.parkinglot.dal;

import java.util.List;

public interface BookingOperations<V,S> {
	public void add(List<S> s);
	public int allot(V v);
	public void release(S s);
}
