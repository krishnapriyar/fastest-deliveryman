
package ModuleE.entity;

import ModuleB.entity.Deliveryman;
import ModuleE.adt.ListImplementation;
import ModuleE.adt.SortedListImplementation;
import ModuleE.adt.SortedListInterface;
import ModuleE.adt.myListInterface;

public class ListGetterSetter {
    private myListInterface<ScheduleOrderClass> scOrderList = new ListImplementation<>();
    private myListInterface<ScheduledOrderItemClass> scOrderItemList = new ListImplementation<>();
    private myListInterface<Customer> custList = new ListImplementation<>();
    private myListInterface<OrderedItemClass> itemlist = new ListImplementation<>();
    private myListInterface<Deliveryman> dmList = new ListImplementation<>();
    private SortedListInterface<ScheduleOrderClass> scOrderClass = new SortedListImplementation<>();
    
    public ListGetterSetter(){
    }
    
    public ListGetterSetter(myListInterface<ScheduleOrderClass> scOrderList, myListInterface<ScheduledOrderItemClass> scOrderItemList, myListInterface<Customer> custList, myListInterface<OrderedItemClass> itemlist, myListInterface<Deliveryman> dmList, SortedListInterface<ScheduleOrderClass> scOrderClass) {
        this.scOrderList = scOrderList;
        this.scOrderItemList = scOrderItemList;
        this.custList = custList;
        this.itemlist = itemlist;
        this.dmList = dmList;
        this.scOrderClass = scOrderClass;
    }
    
    public ListGetterSetter(myListInterface<ScheduleOrderClass> scOrderList, myListInterface<ScheduledOrderItemClass> scOrderItemList, myListInterface<OrderedItemClass> itemlist, myListInterface<Deliveryman> dmList, SortedListInterface<ScheduleOrderClass> scOrderClass) {
        this.scOrderList = scOrderList;
        this.scOrderItemList = scOrderItemList;
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

    public myListInterface<ScheduleOrderClass> getScOrderList() {
        return this.scOrderList;
    }

    public void setScOrderList(myListInterface<ScheduleOrderClass> scOrderList) {
        this.scOrderList = scOrderList;
    }

    public myListInterface<ScheduledOrderItemClass> getScOrderItemList() {
        return this.scOrderItemList;
    }

    public void setScOrderItemList(myListInterface<ScheduledOrderItemClass> scOrderItemList) {
        this.scOrderItemList = scOrderItemList;
    }

    public myListInterface<Deliveryman> getDmList() {
        return this.dmList;
    }

    public void setDmList(myListInterface<Deliveryman> dmList) {
        this.dmList = dmList;
    } 

    public SortedListInterface<ScheduleOrderClass> getScOrderClass() {
        return scOrderClass;
    }

    public void setScOrderClass(SortedListInterface<ScheduleOrderClass> scOrderClass) {
        this.scOrderClass = scOrderClass;
    }
    
    
}
