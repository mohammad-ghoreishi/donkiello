package com.donkiello.model.entity.base;

import org.hibernate.event.spi.*;

import java.util.Map;
import java.util.Set;

/**
 * Base Entity class that provide hibernate event feature.
 * This class also use for implement common methods that will use in all entities.
 *
 * Created by Mohammad Ghoreishi 9/4/2014.
 */
public abstract class BaseEntity {

	public static final Short DELETE_YES = Short.valueOf("1");
    public static final Short DELETE_NO = Short.valueOf("0");
	
    public void onFlushEntity(FlushEntityEvent flushEntityEvent) {}
    public void onDelete(DeleteEvent event){}
    public void onDelete(DeleteEvent event, Set transientEntities){}
    public void onEvict(EvictEvent event){}
    public void onLock(LockEvent event){}
    public void onMerge(MergeEvent event){}
    public void onMerge(MergeEvent event,Map copiedAlready){}
    public void onPostDelete(PostDeleteEvent event){}
    public void onPostInsert(PostInsertEvent event){}
    public void onPostLoad(PostLoadEvent event){}
    public void onPostUpdate(PostUpdateEvent event){}
    public boolean onPreDelete(PreDeleteEvent event){return false;}
    public boolean onPreInsert(PreInsertEvent event){return false;}
    public void onPreLoad(PreLoadEvent event){}
    public boolean onPreUpdate(PreUpdateEvent event){return  false;}
    public void onRefresh(RefreshEvent event){}
    public void onRefresh(RefreshEvent event, Map refreshedAlready){}
    public void onReplicate(ReplicateEvent event){}
    public void onSaveOrUpdate(SaveOrUpdateEvent event){}
    public void onSave(SaveOrUpdateEvent event){}
    public void onUpdate(SaveOrUpdateEvent event){}
}