
package ModuleC.entity;

import ModuleE.entity.*;
import ModuleB.entity.Deliveryman;
import ModuleE.adt.ListImplementation;
import ModuleE.adt.SortedListImplementation;
import ModuleE.adt.SortedListInterface;
import ModuleE.adt.myListInterface;

public class ADTList {
    private myListInterface<OrderClass> OrderList = new ListImplementation<OrderClass>();
    private myListInterface<OrderedItem> OrderItemList = new ListImplementation<OrderedItem>();
    private myListInterface<Customer> cusList = new ListImplementation<Customer>();
    private myListInterface<OrderedItemClass> itemlist = new ListImplementation<OrderedItemClass>();
    private myListInterface<Deliveryman> dmList = new ListImplementation<Deliveryman>();
    
    
    public ADTList(){
    }
    
    public ADTList(myListInterface<OrderClass> scOrderList, myListInterface<OrderedItem> scOrderItemList, myListInterface<Customer> custList, myListInterface<OrderedItemClass> itemlist, myListInterface<Deliveryman> dmList) {
        this.OrderList = OrderList;
        this.OrderItemList = OrderItemList;
        this.cusList = custList;
        this.itemlist = itemlist;
        this.dmList = dmList;
        
    }
    
    public ADTList(myListInterface<OrderClass> scOrderList, myListInterface<OrderedItem> scOrderItemList, myListInterface<OrderedItemClass> itemlist, myListInterface<Deliveryman> dmList) {
        this.OrderList = OrderList;
        this.OrderItemList = OrderItemList;
        this.cusList = cusList;
        this.itemlist = itemlist;
        this.dmList = dmList;
       
    }

    public myListInterface<Customer> getCustList() {
        return cusList;
    }

    public void setCustList(myListInterface<Customer> custList) {
        this.cusList = custList;
    }

    public myListInterface<OrderedItemClass> getItemlist() {
        return this.itemlist;
    }

    public void setItemlist(myListInterface<OrderedItemClass> itemlist) {
        this.itemlist = itemlist;
    }

    public myListInterface<OrderClass> getOrderList() {
        return this.OrderList;
    }

    public void setScOrderList(myListInterface<OrderClass> scOrderList) {
        this.OrderList = OrderList;
    }

    public myListInterface<OrderedItem> getOrderItemList() {
        return this.OrderItemList;
    }

    public void setScOrderItemList(myListInterface<OrderedItem> scOrderItemList) {
        this.OrderItemList = scOrderItemList;
    }

    public myListInterface<Deliveryman> getDmList() {
        return this.dmList;
    }

    public void setDmList(myListInterface<Deliveryman> dmList) {
        this.dmList = dmList;
    } 

   

    
    
}
