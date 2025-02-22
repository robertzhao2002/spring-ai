/*
 * Copyright 2023 the original author or authors.
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

package org.springframework.ai.openai.metadata;

import org.springframework.ai.metadata.Usage;
import org.springframework.util.Assert;

/**
 * {@link Usage} implementation for {@literal OpenAI}.
 *
 * @author John Blum
 * @since 0.7.0
 * @see <a href=
 * "https://platform.openai.com/docs/api-reference/completions/object">Completion
 * Object</a>
 */
public class OpenAiUsage implements Usage {

	public static OpenAiUsage from(com.theokanning.openai.Usage usage) {
		return new OpenAiUsage(usage);
	}

	private final com.theokanning.openai.Usage usage;

	protected OpenAiUsage(com.theokanning.openai.Usage usage) {
		Assert.notNull(usage, "OpenAI Usage must not be null");
		this.usage = usage;
	}

	protected com.theokanning.openai.Usage getUsage() {
		return this.usage;
	}

	@Override
	public Long getPromptTokens() {
		return getUsage().getPromptTokens();
	}

	@Override
	public Long getGenerationTokens() {
		return getUsage().getCompletionTokens();
	}

	@Override
	public Long getTotalTokens() {
		return getUsage().getTotalTokens();
	}

	@Override
	public String toString() {
		return getUsage().toString();
	}

}
