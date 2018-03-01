package storm2.bolt;

//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Set;

import java.util.Map;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import storm2.common.Constants;

//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONException;
//import com.alibaba.fastjson.JSONObject;

@SuppressWarnings({ "serial" })
public class SurfBolt extends BaseRichBolt {
	
	private static Logger log = LoggerFactory.getLogger(SurfBolt.class);
	
//	private static Configuration _conf = HBaseConfiguration.create();
//	private static HTable _hTable = null;
//	private HashMap<String, String> map = new HashMap<String, String>();
//	private List<Row> _bath = new ArrayList<Row>();

	long startTime = System.currentTimeMillis();
    long count = 0;
    int sumCount = 0;
    long hbaseTime = 0;
    
    //use ack
    private OutputCollector _collector;

//    static {
//		_conf.set("hbase.zookeeper.quorum", Constants.hbaseHostList);
//		try {
//			_hTable = new HTable(_conf, "test");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

    @SuppressWarnings("rawtypes")
	public void prepare(Map sconf, TopologyContext context, OutputCollector collector) {
    	_collector = collector;
    }

//	@SuppressWarnings("rawtypes")
	public void execute(Tuple tuple) {
		if (count == 0) {
	    	System.out.println("SurfBolt run success. first msg=[" + tuple.getString(0) + "]");
	    	log.debug("SurfBolt run success. first msg=[" + tuple.getString(0) + "]");
		}
		log.debug("SurfBolt run success. msg=[" + tuple.getString(0) + "]");
		System.out.println("SurfBolt run success. msg=[" + tuple.getString(0) + "]");
//		JSONObject jsonArray = null;
//		JSONObject jsonObject;
//		try {
////			jsonArray = new JSONObject(tuple.getString(0));
//			jsonObject = JSONArray.parseObject(tuple.getString(0));
//		} catch (JSONException e) {
//	    	System.out.println("[ERROE]JSONException." + e.getMessage());
//			return ;
//		}
//
    	count++;
    	
    	_collector.ack(tuple);
    	
//    	this.consoleLog();

//        try {
//			String row_key = jsonArray.get("logisticProviderID").toString() + ":" + jsonArray.get("mailNo").toString();
//			map.put("mailType", jsonArray.get("mailType").toString());
//			map.put("weight", jsonArray.get("weight").toString());
//			map.put("senAreaCode", jsonArray.get("senAreaCode").toString());
//			map.put("recAreaCode", jsonArray.get("recAreaCode").toString());
//			map.put("senCityCode", jsonArray.get("senCityCode").toString());
//			map.put("recCityCode", jsonArray.get("recCityCode").toString());
//			map.put("senProv", jsonArray.get("senProvCode").toString());
//			map.put("senCity", jsonArray.get("senCity").toString());
//			map.put("senCountyCode", jsonArray.get("senCountyCode").toString());
//			map.put("senAddress", jsonArray.get("senAddress").toString());
//			map.put("senName", jsonArray.get("senName").toString());
//			map.put("senMobile", jsonArray.get("senMobile").toString());
//			map.put("senPhone", jsonArray.get("senPhone").toString());
//			map.put("recProvCode", jsonArray.get("recProvCode").toString());
//			map.put("recCity", jsonArray.get("recCity").toString());
//			map.put("recCountyCode", jsonArray.get("recCountyCode").toString());
//			map.put("recAddress", jsonArray.get("recAddress").toString());
//			map.put("recName", jsonArray.get("recName").toString());
//			map.put("recMobile", jsonArray.get("recMobile").toString());
//			map.put("recPhone", jsonArray.get("recPhone").toString());
//			map.put("typeOfContents", jsonArray.get("typeOfContents").toString());
//			map.put("nameOfCoutents", jsonArray.get("nameOfCoutents").toString());
//			map.put("mailCode", jsonArray.get("mailCode").toString());
//			map.put("recDatetime", jsonArray.get("recDatetime").toString());
//			map.put("insuranceValue", jsonArray.get("insuranceValue").toString());
//			Put put = new Put(row_key.getBytes());
//			Set set = map.entrySet();
//			Iterator iterator = set.iterator();
//
//			while (iterator.hasNext()) {
//				Map.Entry mapentry = (Map.Entry) iterator.next();
//				put.add("info".getBytes(), ((String)mapentry.getKey()).getBytes(), ((String)mapentry.getValue()).getBytes());
//			}

//			_bath.add(put);
//			if (_bath.size() == Constants.putCount) {
//				long hbaseStartTime = System.currentTimeMillis();
//
//				Object[] reluts = new Object[_bath.size()];
//				try {
//					_hTable.batch(_bath, reluts);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				_bath.clear();
//
//				long hbaseEndTime = System.currentTimeMillis();
//				hbaseTime += (hbaseEndTime - hbaseStartTime);
//			}
//			map.clear();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
    }

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
	}

	@SuppressWarnings("rawtypes")
	public void prepare(Map arg0, TopologyContext arg1) {
	}

//	private void consoleLog() {
//        if ((count % Constants.sumCount) == 0) {
//        	long sumTime = System.currentTimeMillis();
//        	System.out.println("[RESULT]count=[" + count + "], time=[" + (sumTime - startTime) + "]");
//        	System.out.println("[RESULT]HBase insert time. sumtime=" + hbaseTime);
//        }
//	}
}
