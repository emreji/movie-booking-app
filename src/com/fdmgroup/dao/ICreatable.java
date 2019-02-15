package com.fdmgroup.dao;

import com.fdmgroup.model.IStorable;

public interface ICreatable<T extends IStorable> {
	void create(T t);
}
