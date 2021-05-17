package com.hg.springamqp.constants;

public enum Queues {
    QUEUE("foo.bar", "foo.bar.#");

    private String queueName;
    private String routingKey;

    Queues(String queueName, String routingKey) {
        this.queueName = queueName;
        this.routingKey = routingKey;
    }

    public String getQueueName() {
        return this.queueName;
    }

    public String getRoutingKey() {
        return this.routingKey;
    }
}
