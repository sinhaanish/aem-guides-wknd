/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 ******************************************************************************/
package org.apache.sling.scripting.sightly.apps.wknd.components.image__002d__list;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class image__002d__list__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_imagelist = null;
Object _global_placeholdertemplate = null;
Object _global_itemtemplate = null;
Object _global_hascontent = null;
Collection var_collectionvar0_list_coerced$ = null;
out.write("\n\n\n\n");
_global_imagelist = renderContext.call("use", com.adobe.aem.guides.wknd.core.models.ImageList.class.getName(), obj());
_global_placeholdertemplate = renderContext.call("use", "core/wcm/components/commons/v1/templates.html", obj());
_global_itemtemplate = renderContext.call("use", "item.html", obj());
_global_hascontent = (!renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_imagelist, "empty")));
if (renderContext.getObjectModel().toBoolean(_global_hascontent)) {
    {
        Object var_collectionvar0 = renderContext.getObjectModel().resolveProperty(_global_imagelist, "listItems");
        {
            long var_size1 = ((var_collectionvar0_list_coerced$ == null ? (var_collectionvar0_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar0)) : var_collectionvar0_list_coerced$).size());
            {
                boolean var_notempty2 = (var_size1 > 0);
                if (var_notempty2) {
                    {
                        long var_end5 = var_size1;
                        {
                            boolean var_validstartstepend6 = (((0 < var_size1) && true) && (var_end5 > 0));
                            if (var_validstartstepend6) {
                                out.write("<ul class=\"cmp-image-list\"");
                                {
                                    Object var_attrvalue7 = renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(_global_imagelist, "data"), "json");
                                    {
                                        Object var_attrcontent8 = renderContext.call("xss", var_attrvalue7, "attribute");
                                        {
                                            boolean var_shoulddisplayattr10 = (((null != var_attrcontent8) && (!"".equals(var_attrcontent8))) && ((!"".equals(var_attrvalue7)) && (!((Object)false).equals(var_attrvalue7))));
                                            if (var_shoulddisplayattr10) {
                                                out.write(" data-cmp-data-layer");
                                                {
                                                    boolean var_istrueattr9 = (var_attrvalue7.equals(true));
                                                    if (!var_istrueattr9) {
                                                        out.write("=\"");
                                                        out.write(renderContext.getObjectModel().toString(var_attrcontent8));
                                                        out.write("\"");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                out.write(">");
                                if (var_collectionvar0_list_coerced$ == null) {
                                    var_collectionvar0_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar0);
                                }
                                long var_index11 = 0;
                                for (Object item : var_collectionvar0_list_coerced$) {
                                    {
                                        boolean var_traversal13 = (((var_index11 >= 0) && (var_index11 <= var_end5)) && true);
                                        if (var_traversal13) {
                                            out.write("\n    <li class=\"cmp-image-list__item\"");
                                            {
                                                Object var_attrvalue14 = renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(item, "data"), "json");
                                                {
                                                    Object var_attrcontent15 = renderContext.call("xss", var_attrvalue14, "attribute");
                                                    {
                                                        boolean var_shoulddisplayattr17 = (((null != var_attrcontent15) && (!"".equals(var_attrcontent15))) && ((!"".equals(var_attrvalue14)) && (!((Object)false).equals(var_attrvalue14))));
                                                        if (var_shoulddisplayattr17) {
                                                            out.write(" data-cmp-data-layer");
                                                            {
                                                                boolean var_istrueattr16 = (var_attrvalue14.equals(true));
                                                                if (!var_istrueattr16) {
                                                                    out.write("=\"");
                                                                    out.write(renderContext.getObjectModel().toString(var_attrcontent15));
                                                                    out.write("\"");
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            out.write(">");
                                            {
                                                Object var_templatevar18 = renderContext.getObjectModel().resolveProperty(_global_itemtemplate, "item");
                                                {
                                                    Object var_templateoptions19_field$_item = item;
                                                    {
                                                        java.util.Map var_templateoptions19 = obj().with("item", var_templateoptions19_field$_item);
                                                        callUnit(out, renderContext, var_templatevar18, var_templateoptions19);
                                                    }
                                                }
                                            }
                                            out.write("</li>\n");
                                        }
                                    }
                                    var_index11++;
                                }
                                out.write("</ul>");
                            }
                        }
                    }
                }
            }
        }
        var_collectionvar0_list_coerced$ = null;
    }
}
out.write("\n");
{
    Object var_templatevar20 = renderContext.getObjectModel().resolveProperty(_global_placeholdertemplate, "placeholder");
    {
        boolean var_templateoptions21_field$_isempty = (!renderContext.getObjectModel().toBoolean(_global_hascontent));
        {
            String var_templateoptions21_field$_classappend = "cmp-image-list";
            {
                java.util.Map var_templateoptions21 = obj().with("isEmpty", var_templateoptions21_field$_isempty).with("classAppend", var_templateoptions21_field$_classappend);
                callUnit(out, renderContext, var_templatevar20, var_templateoptions21);
            }
        }
    }
}
out.write("\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

