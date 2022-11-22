package com.delivery;

import java.util.ArrayList;

//import com.delivery.PackageToDeliver;
public class Orders {

	private ArrayList<PackageToDeliver> packageList = new ArrayList<>();
//	private PackageToDeliver delivery = new PackageToDeliver();

	public Orders() {
		// TODO Auto-generated constructor stub

	}

	public ArrayList<PackageToDeliver> getPackageList() {
		return packageList;

	}

	public void addOrder(PackageToDeliver item) {
		packageList.add(item);
	}

	public void access(int i) {
		packageList.get(i);
	}

}
