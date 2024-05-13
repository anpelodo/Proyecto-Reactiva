package com.anpelodo.r2dbc.config;

import com.anpelodo.r2dbc.config.PostgreSQLConnectionPool;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PostgreSQLConnectionPoolTest {

    @Test
    void getConnectionConfig() {
        PostgreSQLConnectionPool postgreSQLConnectionPool= new PostgreSQLConnectionPool();
        Assertions.assertNotNull(postgreSQLConnectionPool.getConnectionConfig());
    }
}
