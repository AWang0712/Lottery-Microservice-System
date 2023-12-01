package com.allanwang.lottery.domain.support.ids;

import com.allanwang.lottery.common.Constants;
import com.allanwang.lottery.domain.support.ids.policy.RandomNumeric;
import com.allanwang.lottery.domain.support.ids.policy.ShortCode;
import com.allanwang.lottery.domain.support.ids.policy.SnowFlake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: ID Strategy Pattern Context Configuration
 * [In a formal complete system architecture,
 * ID generation is done by a separate service,
 * and other services call the ID generation interface.]
 *
 */
@Configuration
public class IdContext {

    /**
     * Creating 'IDs generator strategy' objects is a use of the strategy design pattern
     *
     * @param snowFlake long code, large amount, global unique
     * @param shortCode short code, small amount, global unique
     * @param randomNumeric short code, large amount, global unique
     * @return IIdGenerator interface implementation class
     */
    @Bean
    public Map<Constants.Ids, IIdGenerator> idGenerator(SnowFlake snowFlake, ShortCode shortCode, RandomNumeric randomNumeric) {
        Map<Constants.Ids, IIdGenerator> idGeneratorMap = new HashMap<>(8);
        idGeneratorMap.put(Constants.Ids.SnowFlake, snowFlake);
        idGeneratorMap.put(Constants.Ids.ShortCode, shortCode);
        idGeneratorMap.put(Constants.Ids.RandomNumeric, randomNumeric);
        return idGeneratorMap;
    }

}
