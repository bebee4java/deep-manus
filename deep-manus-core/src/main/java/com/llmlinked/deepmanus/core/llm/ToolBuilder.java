package com.llmlinked.deepmanus.core.llm;


import java.util.List;

import com.llmlinked.deepmanus.core.agent.BaseAgent;
import com.llmlinked.deepmanus.core.service.ChromeDriverService;
import com.llmlinked.deepmanus.core.tool.*;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.model.function.FunctionCallback;
import org.springframework.ai.tool.ToolCallback;

/**
 * @author sgr
 * @create 2025/03/31 0:05
 */
public class ToolBuilder {

    public static List<FunctionCallback> getManusAgentToolCalls(BaseAgent agent, ChatMemory memory,
                                                                String conversationId, ChromeDriverService chromeDriverService) {
        return List.of(GoogleSearch.getFunctionToolCallback(), BrowserUseTool.getFunctionToolCallback(chromeDriverService),
                FileSaver.getFunctionToolCallback(), PythonExecute.getFunctionToolCallback(),
                Summary.getFunctionToolCallback(agent, memory, conversationId));
    }

    public static List<ToolCallback> getManusAgentToolCalls(ChromeDriverService chromeDriverService) {
        return List.of(GoogleSearch.getFunctionToolCallback(), BrowserUseTool.getFunctionToolCallback(chromeDriverService),
                FileSaver.getFunctionToolCallback(), PythonExecute.getFunctionToolCallback());
    }

    public static List<ToolCallback> getPlanningAgentToolCallbacks() {
        return List.of(PlanningTool.getFunctionToolCallback());
    }

}