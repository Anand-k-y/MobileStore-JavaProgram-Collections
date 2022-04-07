package com.jap.collectiondemo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class MobileStore {

	
	public MobileStore()
    {

    }
    public List<Mobile> readMobileData(String fileName)
    {   
    List<Mobile> arr1 = new ArrayList<Mobile>();
    	try (BufferedReader br1 = new BufferedReader(new FileReader(fileName))) {
            br1.readLine();
            String line = "";        
            while ((line = br1.readLine()) != null) {
                
            	String[] arr = line.split(",");
                arr = line.split(",");
                Mobile s = new Mobile();
                s.setBrandName(arr[0]);
                s.setModelName(arr[1]);
                s.setCost(Double.parseDouble(arr[2]));
                s.setScreenSize(arr[3]);
                s.setBatteryLife(arr[4]);
                s.setStorageSpace(arr[5]);
                s.setCameraPixels(Integer.parseInt(arr[6]));
                arr1.add(s);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
         
        return arr1;
    }

    //Find phones of a particular brand.
    public List<Mobile> findPhoneByBrand(String brandName)
    {      List<Mobile> mob= new ArrayList<Mobile>();
    	   mob=readMobileData("mobile.csv");
    	   List<Mobile> res = new ArrayList<Mobile>();
    	   for(Mobile a:mob) {
    		   if(a.getBrandName().equalsIgnoreCase(brandName)) {
    			   res.add(a);
    		   }
    	   }
        return res;
    }

    //Find the phones whose cost is $500 and above.
    public List<Mobile> findPhoneCostMoreThan500$()
    {     
    	List<Mobile> mob= new ArrayList<Mobile>();
 	   mob=readMobileData("mobile.csv");
 	   List<Mobile> res = new ArrayList<Mobile>();
 	   for(Mobile a:mob) {
 		   if(a.getCost()>500) {
 			   res.add(a);
 		   }
 	   }
     return res;
      
    }

    //Enlist the phones which have camera specification as 12 MP and more
    public List<Mobile> findPhonePixelMoreThan12MP()
    {
    	List<Mobile> mob= new ArrayList<Mobile>();
  	   mob=readMobileData("mobile.csv");
  	   List<Mobile> res = new ArrayList<Mobile>();
  	   for(Mobile a:mob) {
  		   if(a.getCameraPixels()>12) {
  			   res.add(a);
  		   }
  	   }
      return res;
        
    }
   
}

