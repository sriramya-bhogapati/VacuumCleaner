package com.edubridge.VacuumCleaner.model;

public class VacuumCleaner {

			private String brand;
			private String filtertype;
			private String powersource;
			private float price;
			private float rating;
			
			public String getBrand() {
				return brand;	
						}
			public void setBrand(String brand) {
				this.brand = brand;
			}
			public String getfiltertype() {
				return filtertype;
			}
			public void setFilterType(String filtertype) {
				this.filtertype = filtertype;
			}
			public String getpowersource() {
				return powersource;
			}
			public void setpowersource(String powersource) {
				this.powersource = powersource;
			}
			public float getprice() {
				return price;
			}
			public void setprice(float price) {
				this.price = price;
			}
			public float getrating() {
				return rating;
			}
			public void setrating(float rating) {
				this.rating = rating;
			}
		}
