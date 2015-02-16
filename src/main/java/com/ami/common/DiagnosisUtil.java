package com.ami.common;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryType;
import java.lang.management.MemoryUsage;
import java.lang.management.ThreadInfo;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class DiagnosisUtil {
  public static JSONArray getMemoryPoolInfo() {
    JSONObject mem;
    JSONArray memPool = new JSONArray();
    Iterator<MemoryPoolMXBean> iter = ManagementFactory.getMemoryPoolMXBeans().iterator();
    while (iter.hasNext()) {
      MemoryPoolMXBean item = iter.next();
      String name = item.getName();
      MemoryType type = item.getType();
      MemoryUsage usage = item.getUsage();
      MemoryUsage peak = item.getPeakUsage();
      MemoryUsage collections = item.getCollectionUsage();
      mem = new JSONObject();
      mem.put("poolName", name);
      mem.put("poolType", type.toString());
      if (usage != null)
        mem.put("usage", usage.toString());
      if (peak != null)
        mem.put("peak", peak.toString());
      if (collections != null)
        mem.put("collections", collections.toString());
      memPool.put(mem);
    }
    return memPool;
  }

  public static JSONObject getThreadPoolInfo() {
    ThreadInfo[] threadsInfo = ManagementFactory.getThreadMXBean().dumpAllThreads(true, true);
    Thread.State[] states = Thread.State.values();
    JSONArray[] threadStates = new JSONArray[states.length];
    int i = 0;
    for (i = 0; i < states.length; i++) {
      threadStates[i] = new JSONArray();
    }
    for (ThreadInfo info : threadsInfo) {
      i = 0;
      for (Thread.State state : states) {
        if (info.getThreadState().equals(state)) {
          threadStates[i].put(info.toString());
          break;
        }
        i++;
      }
    }
    i = 0;
    JSONObject threadInfoPerState;
    JSONArray threadPool = new JSONArray();
    for (JSONArray threadInfo : threadStates) {
      threadInfoPerState = new JSONObject();
      threadInfoPerState.put("threadState", states[i++].name());
      threadInfoPerState.put("threadCount", threadInfo.length());
      threadInfoPerState.put("threadInfo", threadInfo);
      threadPool.put(threadInfoPerState);
    }
    JSONObject pool = new JSONObject();
    pool.put("totalThreadCount", threadsInfo.length);
    pool.put("threadStates", threadPool);
    return pool;
  }
}