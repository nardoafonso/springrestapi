package com.example.demo.business.commons;

@FunctionalInterface
public interface UseCase<T> {
    T execute();
}