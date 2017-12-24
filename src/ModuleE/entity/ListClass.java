
package ModuleE.entity;

import ModuleE.adt.ListImplementation;
import ModuleE.adt.SortedListImplementation;
import ModuleE.adt.SortedListInterface;
import ModuleE.adt.myListInterface;

public class ListClass {
    private myListInterface<ScheduledOrderClass> scOrderList = new ListImplementation<ScheduledOrderClass>();
    private myListInterface<ScheduledOrderItem> scOrderItemList = new ListImplementation<ScheduledOrderItem>();
    private myListInterface<Customer> custList = new ListImplementation<Customer>();
    private myListInterface<OrderedItemClass> itemlist = new ListImplementation<OrderedItemClass>();
    private myListInterface<DeliveryManClass> dmList = new ListImplementation<DeliveryManClass>();
    private SortedListInterface<ScheduledOrderClass> scOrderClass = new SortedListImplementation<>();
    
    public ListClass(){
    }
    
    public ListClass(myListInterface<ScheduledOrderClass> scOrderList, myListInterface<ScheduledOrderItem> scOrderItemList, myListInterface<Customer> custList, myListInterface<OrderedItemClass> itemlist, myListInterface<DeliveryManClass> dmList, SortedListInterface<ScheduledOrderClass> scOrderClass) {
        this.scOrderList = scOrderList;
        this.scOrderItemList = scOrderItemList;
        this.custList = custList;
        this.itemlist = itemlist;
        this.dmList = dmList;
        this.scOrderClass = scOrderClass;
    }
    
    public ListClass(myListInterface<ScheduledOrderClass> scOrderList, myListInterface<ScheduledOrderItem> scOrderItemList, myListInterface<OrderedItemClass> itemlist, myListInterface<DeliveryManClass> dmList, SortedListInterface<ScheduledOrderClass> scOrderClass) {
        this.scOrderList = scOrderList;
        this.scOrderItemList = scOrderItemList;
        this.custList = custList;
        this.itemlist = itemlist;
        this.dmList = dmList;
        this.scOrderClass = scOrderClass;
    }

    public myListInterface<Customer> getCustList() {
        return custList;
    }

    public void setCustList(myListInterface<Customer> custList) {
        this.custList = custList;
    }

    public myListInterface<OrderedItemClass> getItemlist() {
        return this.itemlist;
    }

    public void setItemlist(myListInterface<OrderedItemClass> itemlist) {
        this.itemlist = itemlist;
    }

    public myListInterface<ScheduledOrderClass> getScOrderList() {
        return this.scOrderList;
    }

    public void setScOrderList(myListInterface<ScheduledOrderClass> scOrderList) {
        this.scOrderList = scOrderList;
    }

    public myListInterface<ScheduledOrderItem> getScOrderItemList() {
        return this.scOrderItemList;
    }

    public void setScOrderItemList(myListInterface<ScheduledOrderItem> scOrderItemList) {
        this.scOrderItemList = scOrderItemList;
    }

    public myListInterface<DeliveryManClass> getDmList() {
        return this.dmList;
    }

    public void setDmList(myListInterface<DeliveryManClass> dmList) {
        this.dmList = dmList;
    } 

    public SortedListInterface<ScheduledOrderClass> getScOrderClass() {
        return scOrderClass;
    }

    public void setScOrderClass(SortedListInterface<ScheduledOrderClass> scOrderClass) {
        this.scOrderClass = scOrderClass;
    }
    
    
}
