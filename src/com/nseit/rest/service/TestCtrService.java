package com.nseit.rest.service;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.Query;
import org.hibernate.Session;

import com.nseit.rest.model.OesDashboard1;
import com.nseit.rest.model.OesDashboardId;
import com.nseit.rest.model.TestCtr;
import com.nseit.rest.model.TestCtrSummary;



@Path("/json/tstctr")
public class TestCtrService extends BaseService{
	
	/*@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public TestCenter getTrackInJSON() {
		TestCenter track = new TestCenter();
		return track;
	}*/
	
	@SuppressWarnings("unchecked")
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TestCtr> getTrackInJSON() {
		Session session = sessionFactory.openSession();
		List<String> track = session.createQuery("Select odContent from OesDashboard").list();
		List<TestCtr> tcList = new ArrayList<TestCtr>();
		for(String js:track){
			ObjectMapper mapper = new ObjectMapper();
			//JSON from URL to Object
			TestCtr obj;
			try {
				obj = mapper.readValue(js, TestCtr.class);
				tcList.add(obj);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		session.close();
		return tcList;
	}
	
	/*@SuppressWarnings("unchecked")
	@GET
	@Path("/get/{batch}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TestCtr> getTrackInJSON(@PathParam("batch") String batch) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("Select odContent from OesDashboard od WHERE od.id.odBatch='"+batch+"'");
		//Caching Query.
		//q.setCacheable(true);
		List<String> track = q.list();
		List<TestCtr> tcList = new ArrayList<TestCtr>();
		for(String js:track){
			ObjectMapper mapper = new ObjectMapper();
			//JSON from URL to Object
			TestCtr obj;
			try {
				obj = mapper.readValue(js, TestCtr.class);
				tcList.add(obj);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		session.close();
		return tcList;
	}*/
	
		
	/*@SuppressWarnings("unchecked")
	@GET
	@Path("/get/{batch}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<JSONObject> getTestCtrInJSON(@PathParam("batch") String batch) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("Select odContent from OesDashboard1 od WHERE od.id.odBatch='"+batch+"'");
		//Caching Query.
		//q.setCacheable(true);
		List<JSONObject> track = q.list();
		session.close();
		return track;
	}*/
	
	//URL - http://172.25.18.58:8080/OESRest/rest/json/tstctr/get/10:00-12:00
	
	/*@SuppressWarnings("unchecked")
	@GET
	@Path("/get/{batch}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TestCtr> getTrackInJSON(@PathParam("batch") String batch) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("Select odContent from OesDashboard1 od WHERE od.id.odBatch='"+batch+"'");
		//Caching Query.
		//q.setCacheable(true);
		List<String> track = q.list();
		List<TestCtr> tcList = new ArrayList<TestCtr>();
		for(String js:track){
			ObjectMapper mapper = new ObjectMapper();
			//JSON from URL to Object
			TestCtr obj;
			try {
				obj = mapper.readValue(js, TestCtr.class);
				tcList.add(obj);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		session.close();
		return tcList;
	}*/
	//URL - http://172.25.18.58:8080/OESRest/rest/json/tstctr/get/10:00-12:00
	@SuppressWarnings("unchecked")
	@GET
	@Path("/get/{batch}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTrackInJSON(@PathParam("batch") String batch) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("Select odContent from OesDashboard1 od WHERE od.id.odBatch='"+batch+"'");
		//Caching Query.
		//q.setCacheable(true);
		List<String> track = q.list();
		List<TestCtr> tcList = new ArrayList<TestCtr>();
		for(String js:track){
			ObjectMapper mapper = new ObjectMapper();
			//JSON from URL to Object
			TestCtr obj;
			try {
				obj = mapper.readValue(js, TestCtr.class);
				tcList.add(obj);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		session.close();
		return Response.status(201).entity(tcList).header("Access-Control-Allow-Origin", "*")
		         .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
	}
	
	
	//URL - http://localhost:8080/OESRestWebService/rest/json/tstctr/get/summary/10:00-12:00
	@SuppressWarnings("unchecked")
	@GET
	@Path("/get/summary/{batch}")
	@Produces(MediaType.APPLICATION_JSON)
	public TestCtrSummary getSummaryInJSON(@PathParam("batch") String batch) {
		Session session = sessionFactory.openSession();
		Query q = session.createSQLQuery("SELECT sum(CAST(coalesce(od_content->>'appear', '0') AS integer)) as aprCnt,sum(CAST(coalesce(od_content->>'absenCand', '0') AS integer)) AS absenCand, sum(CAST(coalesce(od_content->>'totCand', '0') AS integer)) AS totCand FROM oes_dashboard1 where od_batch='"+batch+"'");
		//Caching Query.
		//q.setCacheable(true);
		List<Object[]> rows = q.list();
		int i = 0;
		TestCtrSummary tcs = new TestCtrSummary();
		for(Object[] row : rows){
			tcs.setAppCnt((BigInteger)row[i++]);
			tcs.setAbsCnt((BigInteger)row[i++]);
			tcs.setTtlCnt((BigInteger)row[i++]);
		}
		
		session.close();
		return tcs;
	}
	
	//URL - http://localhost:8080/OESRestWebService/rest/json/tstctr/post
	@POST
	@Path("/webpost")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response createTrackJSON(TestCtr track) {

		String result = "Track saved : " + track.getPullTime()+ track.getResPullFlag();
		ObjectMapper mapper = new ObjectMapper();
		//Object to JSON in file
		//mapper.writeValue(new File("c:\\file.json"), obj);

		//Object to JSON in String
		String jsonInString = null;
		try {
			jsonInString = mapper.writeValueAsString(track);

			System.out.println("Data"+jsonInString);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(null!=jsonInString){
			Date dt = new Date();
			OesDashboardId id = new OesDashboardId();
			id.setOdTcId(Long.valueOf(track.getCode()));
			id.setOdBatch(track.getSession());
			id.setOdTestDate(dt);
			
			Timestamp ts = new Timestamp(dt.getTime());
			OesDashboard1 od = new OesDashboard1();
			od.setId(id);
			od.setOdAuditDt(ts);
			//od.setOdContent(jsonInString);

			//javax.json.JsonObject body = Json.createReader(new StringReader(TEXT)).readObject()
			//System.out.println(jsonFromString(jsonInString));
			
			 JSONObject object = null;
			
				try {
					object = new JSONObject(jsonInString);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//object = mapper.readValue(jsonInString, org.json.JSONObject.class);
			
			od.setOdContent(object);

			Session session = sessionFactory.openSession();
			
			session.beginTransaction();

			session.merge(od);
			//session.merge(od1);
			
			session.getTransaction().commit();
			
			session.close();
			
		}

		
		//return Response.status(201).entity(result).build();
		return Response.status(201).entity(result).header("Access-Control-Allow-Origin", "*")
		         .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();

		
		
	}
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(TestCtr track) {

		String result = "Track saved : " + track.getPullTime()+ track.getResPullFlag();
		ObjectMapper mapper = new ObjectMapper();
		//Object to JSON in file
		//mapper.writeValue(new File("c:\\file.json"), obj);

		//Object to JSON in String
		String jsonInString = null;
		try {
			jsonInString = mapper.writeValueAsString(track);

			System.out.println("Data"+jsonInString);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(null!=jsonInString){
			Date dt = new Date();
			OesDashboardId id = new OesDashboardId();
			id.setOdTcId(Long.valueOf(track.getCode()));
			id.setOdBatch(track.getSession());
			id.setOdTestDate(dt);
			
			Timestamp ts = new Timestamp(dt.getTime());
			OesDashboard1 od = new OesDashboard1();
			od.setId(id);
			od.setOdAuditDt(ts);

			//javax.json.JsonObject body = Json.createReader(new StringReader(TEXT)).readObject()
			//System.out.println(jsonFromString(jsonInString));
			
			JSONObject object = null;
			
				try {
					object = new JSONObject(jsonInString);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//object = mapper.readValue(jsonInString, org.json.JSONObject.class);
			
			od.setOdContent(object);

			Session session = sessionFactory.openSession();
			
			session.beginTransaction();

			session.saveOrUpdate(od);
			//session.merge(od1);
			
			session.getTransaction().commit();
			
			session.close();
			
		}

		
		//return Response.status(201).entity(result).build();
		return Response.status(201).entity(result).header("Access-Control-Allow-Origin", "*")
		         .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();

		
		
	}
	
	/*
	 * --start Batch
SELECT count(1) as startTimeCnt FROM oes_dashboard1 where od_batch='10:00-12:00' and length(CAST(coalesce(od_content->>'startTime', '') AS text))>0

--stop Batch
SELECT count(1) as sessionEndCnt FROM oes_dashboard1 where od_batch='10:00-12:00' and length(CAST(coalesce(od_content->>'sessionEnd', '') AS text))>0

--result push
SELECT count(1) as resPushTimeCnt FROM oes_dashboard1 where od_batch='10:00-12:00' and length(CAST(coalesce(od_content->>'resPushTime', '') AS text))>0

--result pull
SELECT count(1) as resPullTimeCnt FROM oes_dashboard1 where od_batch='10:00-12:00' and length(CAST(coalesce(od_content->>'resPullTime', '') AS text))>0

--back up
SELECT count(1) as bkupTimeCnt FROM oes_dashboard1 where od_batch='10:00-12:00' and length(CAST(coalesce(od_content->>'bkupTime', '') AS text))>0

--clean up
SELECT count(1) as clnupTimeCnt FROM oes_dashboard1 where od_batch='10:00-12:00' and length(CAST(coalesce(od_content->>'clnupTime', '') AS text))>0

	 * */
}
