/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

import org.slf4j.LoggerFactory;

/**
 *
 * @author SKILLLOTO G006
 */
public class Communicator {/*
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Communicator.class);
    
    
    // for GSP 
    
    public static String callGSTForAuthentication(JsonObject empObj,String serviceMethod) {
  		StringBuilder reqJson = null;
  		HttpURLConnection connection = null;
  		BufferedReader in = null;
  		StringBuilder urlString = new StringBuilder();
  		try {
  			urlString.append("http://devapi.gstsystem.co.in/taxpayerapi/v0.1/authenticate");
  			logger.info("***** URL for GST Calling {}"+urlString.toString());
  			URL url = new URL(urlString.toString());
  			connection = (HttpURLConnection) url.openConnection();
  			connection.setDoOutput(true);
  			connection.setRequestMethod(serviceMethod);
  			connection.setRequestProperty("Content-Type", "application/json");
  			connection.setRequestProperty("clientid","l7xx6df7496552824f15b7f4523c0a1fc114");
  			connection.setRequestProperty("client-secret","f328fe52752349c893aa93adcffed8f5");
  			connection.setRequestProperty("state-cd", "11");
  			connection.setRequestProperty("txn",  ProjectUtils.getTranId());
              connection.setRequestProperty("ip-usr", "172.20.2.136");
  			//connection.setRequestProperty("username", "GSPTESTUSER1");
  			//connection.setRequestProperty("appkey", "48Kw7zR3L9nsbBJI3BJBmg8K0cx/XoGzR6uJHcBCuEPUlBTDPLochguhJk1DTvvHYQqQwaU0yhOqfZHgalD9sGMikaEBmY7Y1YcjP5drvwhmmcqQmCLK3D1FE18ditvlqV4DWou5feLM07QwWTj/i8mDwc5YgWz0cYnr6r7wnd2nlbmMxdHOYbKjOP6SxOdD2Gb6GZDI5+RFkkfGSPKwtvXR9NfZQaLaTIY1w8O0X0NI56C9oqjcqT5+FgdpTnLYc3rodHJuEFVgqfeTpWSk3QfAcnQg9P1N9Azcx2OI+AXbLLhcLLbSpfveelhaK02uEdUDYgGHfztr//9RPfqOzg==");

  			long t1 = System.currentTimeMillis();
  			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
  			Gson gson = new Gson();
  		   String json = gson.toJson(empObj);
  			
  			out.write(json);
  			out.close();
  			logger.info("Time Taken for GST Request - {}"+(System.currentTimeMillis() - t1));

  			int responseCode = connection.getResponseCode();
  			reqJson = new StringBuilder("");
  			if (responseCode == 200) {
  				in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
  				String responseString;
  				while ((responseString = in.readLine()) != null) {
  					reqJson.append(responseString);
  				}
  			} else {
  				in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
  				String responseString;
  				while ((responseString = in.readLine()) != null) {
  					reqJson.append(responseString);
  				}
  				return reqJson.toString();
  			}
  			logger.info("Response String From GST {}"+reqJson.toString());
  			System.out.println("Response String From GST {}"+reqJson.toString());
  			logger.info("&gspGSTNRequest={}&requestData={}&responseData={}&requestUrl={}&totalRespTime={}","gstnReqData",json,reqJson,urlString.toString(),(System.currentTimeMillis() - t1));
  			
  			in.close();
  		} catch (MalformedURLException e) {
  			e.printStackTrace();
  		} catch (ProtocolException e) {
  			e.printStackTrace();
  		} catch (IOException e) {
  			e.printStackTrace();
  		} catch (Exception e) {
  			e.printStackTrace();
  		} finally {
  			try {
  				if (in != null) {
  					in.close();
  				}
  				if (connection != null) {
  					connection.disconnect();
  				}
  			} catch (Exception e) {
  				e.printStackTrace();
  			}
  		}
  		return reqJson.toString();
  	}
    
         // for ASP
    
        public static String callGSTForAuthentication(String empObj,String serviceMethod) {
		StringBuilder reqJson = null;
		HttpURLConnection connection = null;
		BufferedReader in = null;
		StringBuilder urlString = new StringBuilder();
		try {
			urlString.append("http://devapi.gstsystem.co.in/taxpayerapi/v0.1/authenticate");
			logger.info("***** URL for GST Calling {}"+urlString.toString());
			URL url = new URL(urlString.toString());
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod(serviceMethod);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("clientid","l7xx6df7496552824f15b7f4523c0a1fc114");
			connection.setRequestProperty("client-secret","f328fe52752349c893aa93adcffed8f5");
			connection.setRequestProperty("state-cd", "11");
			connection.setRequestProperty("txn",  ProjectUtils.getTranId());
            connection.setRequestProperty("ip-usr", "172.20.2.136");
			//connection.setRequestProperty("username", "GSPTESTUSER1");
			//connection.setRequestProperty("appkey", "48Kw7zR3L9nsbBJI3BJBmg8K0cx/XoGzR6uJHcBCuEPUlBTDPLochguhJk1DTvvHYQqQwaU0yhOqfZHgalD9sGMikaEBmY7Y1YcjP5drvwhmmcqQmCLK3D1FE18ditvlqV4DWou5feLM07QwWTj/i8mDwc5YgWz0cYnr6r7wnd2nlbmMxdHOYbKjOP6SxOdD2Gb6GZDI5+RFkkfGSPKwtvXR9NfZQaLaTIY1w8O0X0NI56C9oqjcqT5+FgdpTnLYc3rodHJuEFVgqfeTpWSk3QfAcnQg9P1N9Azcx2OI+AXbLLhcLLbSpfveelhaK02uEdUDYgGHfztr//9RPfqOzg==");

			long t1 = System.currentTimeMillis();
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
		
			
			String json =empObj;
			out.write(json);
			out.close();
			logger.info("Time Taken for GST Request - {}"+(System.currentTimeMillis() - t1));

			int responseCode = connection.getResponseCode();
			reqJson = new StringBuilder("");
			if (responseCode == 200) {
				in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String responseString;
				while ((responseString = in.readLine()) != null) {
					reqJson.append(responseString);
				}
			} else {
				in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				String responseString;
				while ((responseString = in.readLine()) != null) {
					reqJson.append(responseString);
				}
				return reqJson.toString();
			}
			logger.info("Response String From GST {}"+reqJson.toString());
			System.out.println("Response String From GST {}"+reqJson.toString());
			logger.info("&gspGSTNRequest={}&requestData={}&responseData={}&requestUrl={}&totalRespTime={}","gstnReqData",json,reqJson,urlString.toString(),(System.currentTimeMillis() - t1));
			
			in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (connection != null) {
					connection.disconnect();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return reqJson.toString();
	}
        
        
        //For ASP   *******************************************************************************************************
        
        public static String callGSTFoReturnPostAndPutAPI(String jsonObj,String requestType,String serviceMethod,String authToken) {
        	
    		StringBuilder reqJson = null;
    		HttpURLConnection connection = null;
    		BufferedReader in = null;
    		StringBuilder urlString = new StringBuilder();
    		long t1=0;
    		Gson gson = new Gson();
    		try {                                                  
    			urlString.append("http://devapi.gstsystem.co.in/taxpayerapi/v0.1/returns/").append(serviceMethod);
    			logger.info("***** URL for GST Calling {}"+urlString.toString());
    			URL url = new URL(urlString.toString());
    			connection = (HttpURLConnection) url.openConnection();
    			connection.setDoOutput(true);
    			connection.setRequestMethod(requestType);
    			connection.setRequestProperty("Content-Type", "application/json");
    			connection.setRequestProperty("clientid","l7xx6df7496552824f15b7f4523c0a1fc114");
    			connection.setRequestProperty("client-secret","f328fe52752349c893aa93adcffed8f5");
    			connection.setRequestProperty("state-cd", "11");
    			connection.setRequestProperty("txn",  ProjectUtils.getTranId());
                connection.setRequestProperty("ip-usr", "172.20.2.136");
                connection.setRequestProperty("auth-token",authToken);
    			connection.setRequestProperty("username", "GSPTESTUSERASHOK");
    			 t1 = System.currentTimeMillis();
    			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
    			String json = gson.toJson(jsonObj);
    			System.out.println(jsonObj);
    			out.write(jsonObj);
    			out.close();
    			logger.info("Time Taken for GST Request - {}"+(System.currentTimeMillis() - t1));

    			int responseCode = connection.getResponseCode();
    			reqJson = new StringBuilder("");
    			if (responseCode == 200) {
    				in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    				String responseString;
    				while ((responseString = in.readLine()) != null) {
    					reqJson.append(responseString);
    				}
    			} else {
    				in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
    				String responseString;
    				while ((responseString = in.readLine()) != null) {
    					reqJson.append(responseString);
    				}
    				return reqJson.toString();
    			}
    			logger.info("Response String From GST {}"+reqJson.toString());
    			in.close();
    		} catch (MalformedURLException e) {
    			e.printStackTrace();
    		} catch (ProtocolException e) {
    			e.printStackTrace();
    		} catch (IOException e) {
    			e.printStackTrace();
    		} catch (Exception e) {
    			e.printStackTrace();
    		} finally {
    			try {
    				if (in != null) {
    					in.close();
    				}
    				if (connection != null) {
    					connection.disconnect();
    				}
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    		}
    	//	logger.info("&gspGSTNRequest={}&requestData={}&responseData={}&requestUrl={}&totalRespTime={}","gstnReqData",gson.toJson(jsonObj),AESEncryption.decryptAndPrintGSTAPIResponseData(reqJson.toString()),urlString.toString(),(System.currentTimeMillis() - t1));
    		return reqJson.toString();
    	}
        
        //For GSTN       ********************************************************************************************
        
        public static String callGSTFoReturnPostAndPutAPI(JsonObject jsonObj,String requestType,String serviceMethod,String authToken) {
        	
		StringBuilder reqJson = null;
		HttpURLConnection connection = null;
		BufferedReader in = null;
		StringBuilder urlString = new StringBuilder();
		long t1=0;
		Gson gson = new Gson();
		try {                                                  
			urlString.append("http://devapi.gstsystem.co.in/taxpayerapi/v0.1/returns/").append(serviceMethod);
			logger.info("***** URL for GST Calling {}"+urlString.toString());
			URL url = new URL(urlString.toString());
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod(requestType);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("clientid","l7xx6df7496552824f15b7f4523c0a1fc114");
			connection.setRequestProperty("client-secret","f328fe52752349c893aa93adcffed8f5");
			connection.setRequestProperty("state-cd", "11");
			connection.setRequestProperty("txn",  ProjectUtils.getTranId());
            connection.setRequestProperty("ip-usr", "172.20.2.75");
            connection.setRequestProperty("auth-token",authToken);
			connection.setRequestProperty("username", "GSPTESTUSERASHOK");
			 t1 = System.currentTimeMillis();
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			String json = gson.toJson(jsonObj);
			System.out.println(jsonObj);
			out.write(json);
			out.close();
			logger.info("Time Taken for GST Request - {}"+(System.currentTimeMillis() - t1));

			int responseCode = connection.getResponseCode();
			reqJson = new StringBuilder("");
			if (responseCode == 200) {
				in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String responseString;
				while ((responseString = in.readLine()) != null) {
					reqJson.append(responseString);
				}
			} else {
				in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				String responseString;
				while ((responseString = in.readLine()) != null) {
					reqJson.append(responseString);
				}
				return reqJson.toString();
			}
			logger.info("Response String From GST {}"+reqJson.toString());
			in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (connection != null) {
					connection.disconnect();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	//	logger.info("&gspGSTNRequest={}&requestData={}&responseData={}&requestUrl={}&totalRespTime={}","gstnReqData",gson.toJson(jsonObj),AESEncryption.decryptAndPrintGSTAPIResponseData(reqJson.toString()),urlString.toString(),(System.currentTimeMillis() - t1));
		return reqJson.toString();
	}
        
        
        public static String callGSTForReturnGetApi(String urlDataAppender,String serviceMethod,String auth_token,String appKey) {
		StringBuilder reqJson = null;
		HttpURLConnection connection = null;
		BufferedReader in = null;
		StringBuilder urlString = new StringBuilder();
		long t1=0;
		try {
			urlString.append("http://devapi.gstsystem.co.in/taxpayerapi/v0.1/returns/").append(serviceMethod).append(urlDataAppender);
			                 System.out.println(""+urlString.toString());
                        logger.info("***** URL for GST Calling {}"+urlString.toString());
			URL url = new URL(urlString.toString());
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("clientid","l7xx6df7496552824f15b7f4523c0a1fc114");
			connection.setRequestProperty("client-secret","f328fe52752349c893aa93adcffed8f5");
			connection.setRequestProperty("state-cd", "11");
			connection.setRequestProperty("txn",  ProjectUtils.getTranId());
                        connection.setRequestProperty("ip-usr", "172.20.2.75");
                        connection.setRequestProperty("username", "GSPTESTUSERASHOK");
                        connection.setRequestProperty("auth-token",auth_token);
			connection.setRequestProperty("appkey", ""+appKey);
//                        
                        
			t1 = System.currentTimeMillis();
			logger.info("Time Taken for GST Request - {}"+(System.currentTimeMillis() - t1));

			int responseCode = connection.getResponseCode();
			reqJson = new StringBuilder("");
			if (responseCode == 200) {
				in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String responseString;
				while ((responseString = in.readLine()) != null) {
					reqJson.append(responseString);
				}
			} else {
				in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				String responseString;
				while ((responseString = in.readLine()) != null) {
					reqJson.append(responseString);
				}
				return "Response code is:"+responseCode+""+reqJson.toString();
			}
			System.out.println("Response String From GST {}"+reqJson.toString());
			logger.info("&gspGSTNRequest={}&requestData={}&responseData={}&requestUrl={}&totalRespTime={}","gstnReqData",urlDataAppender,reqJson,urlString.toString(),(System.currentTimeMillis() - t1));
			in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (connection != null) {
					connection.disconnect();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	//	logger.info("&gspGSTNRequest={}&requestData={}&responseData={}&requestUrl={}&totalRespTime={}","gstnReqData","",AESEncryption.decryptAndPrintGSTAPIResponseData(reqJson.toString()),urlString.toString(),(System.currentTimeMillis() - t1));
		return reqJson.toString();
	}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        *//**************************************************************************//*
        public String requestGet(String requestUrl,String authKey){
        HttpURLConnection conn = null;
        String response;
        try {
                URL url = new URL(requestUrl); 
                conn = (HttpURLConnection) url.openConnection();
                //conn.setRequestProperty ("api_key","");
                //if(authKey != null)
                   // conn.setRequestProperty ("auth_key",authKey);
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");
                conn.setConnectTimeout(5000); 
                conn.setReadTimeout(30000);
                if(conn.getResponseCode() != 200){
                   return response = AppConstant.RESPONSE_ERRMSG+":"+conn.getResponseCode();
                }
                response = IOUtils.toString(conn.getInputStream());
                System.out.println(response);
            } catch (Exception exception) {
                logger.info("Response Not Found:\t" + exception.toString());
                System.out.println(exception.toString());
                response = AppConstant.RESPONSE_ERRMSG;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }

        return response;
    }
  
    public String requestPost(String requestUrl,String auth_key,String payLoad){
        HttpURLConnection conn = null;
        String response = null;
        try {
                URL url = new URL(requestUrl); 
                conn = (HttpURLConnection) url.openConnection();
                //conn.setRequestProperty("api_key",AppConstants.API_KEY);
                //if(auth_key != null)
                //    conn.setRequestProperty ("auth_key",auth_key);
                conn.setDoOutput(true);
                conn.setDoInput(true); 
                conn.setRequestProperty("Content-Type","application/json");
                conn.setRequestProperty("Accept","application/json");
                conn.setConnectTimeout(50000); 
                conn.setReadTimeout(45000);
                if(payLoad != null){
                    IOUtils.write(payLoad,conn.getOutputStream());
                }
                if(conn.getResponseCode() != 200){
                   return response = AppConstant.RESPONSE_ERRMSG+":"+conn.getResponseCode();
                }
               response = IOUtils.toString(conn.getInputStream());
               System.out.println(response);
        } catch (Exception exception) {
               logger.info("Response Not Found:\t" + exception.toString());
               System.out.println(exception.toString());
               response = AppConstant.RESPONSE_ERRMSG;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }

        return response;
    }

*/}
