package com.demo.docker.model;

import com.orbitz.consul.Consul;
import com.orbitz.consul.KeyValueClient;

public class ConsulInstance {

	private static Consul consul = Consul.builder().build(); // connect to localhost
//	private static Consul consul = Consul.builder().withUrl("http://consul-service.softtoken-dev:8500").build(); // connect to
	// Consul on
//	private static Consul consul = Consul.builder().withUrl("http://consul:8500").build(); // connect to
	private static KeyValueClient kvClient = consul.keyValueClient();

	/**
	 * @return the consul
	 */
	public static Consul getConsul() {
		return consul;
	}

	/**
	 * @param consul
	 *            the consul to set
	 */
	public static void setConsul(Consul consul) {
		ConsulInstance.consul = consul;
	}

	/**
	 * @return the kvClient
	 */
	public static KeyValueClient getKvClient() {
		return kvClient;
	}

	/**
	 * @param kvClient
	 *            the kvClient to set
	 */
	public static void setKvClient(KeyValueClient kvClient) {
		ConsulInstance.kvClient = kvClient;
	}

}
