/*
 * Copyright 2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.llmlinked.deepmanus.core.config;

import com.llmlinked.deepmanus.core.flow.PlanningFlow;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class QueryCommandRunner implements CommandLineRunner {

	private final PlanningFlow planningFlow;

	public QueryCommandRunner(PlanningFlow planningFlow) {
		this.planningFlow = planningFlow;
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		while (true) {

			System.out.println("Enter your query (or type 'exit' to quit): ");
			String query = scanner.nextLine();

			if ("exit".equalsIgnoreCase(query)) {
				System.out.println("Exiting...");
				break;
			}

			planningFlow.setActivePlanId("plan_" + System.currentTimeMillis());
			String result = planningFlow.execute(query);
			System.out.println("plan : " + planningFlow.getConversationId() + " Result: " + result);
		}

		scanner.close();
	}

}
