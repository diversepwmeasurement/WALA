/*******************************************************************************
 * Copyright (c) 2002 - 2006 IBM Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.wala.eclipse.cg.model;

import com.ibm.wala.cast.java.ipa.callgraph.JavaSourceAnalysisScope;
import com.ibm.wala.ipa.callgraph.*;
import com.ibm.wala.ipa.cha.ClassHierarchy;
import com.ibm.wala.util.graph.InferGraphRootsImpl;
import com.ibm.wala.util.warnings.WalaException;
import org.eclipse.jdt.core.*;

import java.util.Collection;

/**
 * 
 * @author aying
 */
public class WalaProjectCGModelWithMain extends WalaProjectCGModel {

  public WalaProjectCGModelWithMain(IJavaProject project) {
    super(project);
  }


  protected Entrypoints getEntrypoints(AnalysisScope scope, ClassHierarchy cha) {
    
    return com.ibm.wala.ipa.callgraph.impl.Util.makeMainEntrypoints(JavaSourceAnalysisScope.SOURCE_REF, cha);
  }

  protected Collection inferRoots(CallGraph cg) throws WalaException {
    return InferGraphRootsImpl.inferRoots(cg);
  }

}
