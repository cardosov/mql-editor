package org.pentaho.commons.metadata.mqleditor.editor.models;

import java.util.ArrayList;
import java.util.List;

import org.pentaho.commons.metadata.mqleditor.beans.Condition;

public class Conditions extends AbstractModelNode<UICondition>{

    
  public Conditions(){
  }
  
  public Conditions(List<UICondition> conditions){
    super(conditions);
  }

  
  public List<Condition> getBeanCollection(){
    List<Condition> conditions = new ArrayList<Condition>();
    
    for(UICondition c : this.getChildren()){
      conditions.add(c.getBean());
    }
    return conditions;
  }
}

  