package com.monpro.ticket.common.util;

import cn.hutool.core.util.IdUtil;

public class SnowFlakeUtil {

    // Those Ids should be read from .env in production
    private static long dataCenterId = 1;
    private static long workerId = 1;

    public static long getSnowflakeNextId() {
        return IdUtil.getSnowflake(workerId, dataCenterId).nextId();
    }

    public static String getSnowflakeNextIdStr() {
        return IdUtil.getSnowflake(workerId, dataCenterId).nextIdStr();
    }
}
