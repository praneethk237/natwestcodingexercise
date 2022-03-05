package com.company.natwest.persistence;

import com.company.natwest.model.CustomStructure;
import com.company.natwest.model.InstrumentType;

import java.util.HashMap;

public class CustomPersistence
{
      public static HashMap<InstrumentType, CustomStructure> database;
      public CustomPersistence(HashMap<InstrumentType, CustomStructure> hashMap)
      {
            this.database = hashMap;
      }
}
