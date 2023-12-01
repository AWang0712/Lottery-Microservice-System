package com.allanwang.lottery.domain.support.ids;

/**
 * @description: generate id interface
 **/
public interface IIdGenerator {

    /**
     * To get the ID, there are currently 3 implementations
     *
     * 1. Snowflake algorithm for generating order numbers
     * 2. Date algorithm for generating activity number,
     * characterized by generating shorter strings of numbers, but not too many in a given time period
     * 3. Randomized algorithm for generating strategy IDs
     *
     * @return ID
     */
    long nextId();

}

