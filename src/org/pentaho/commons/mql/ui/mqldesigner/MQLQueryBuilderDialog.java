package org.pentaho.commons.mql.ui.mqldesigner;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.pentaho.pms.mql.MQLQuery;

public class MQLQueryBuilderDialog extends Dialog {

  MQLQueryBuilderComposite mqlQueryBuilderComposite;
  MQLQuery mqlQuery;
  
  public MQLQueryBuilderDialog(Shell parentShell, MQLQuery mqlQuery) {
    super(parentShell);
    this.mqlQuery = mqlQuery;
    setShellStyle(SWT.RESIZE | SWT.DIALOG_TRIM);
  }

  public MQLQueryBuilderDialog(Shell parentShell) {
    super(parentShell);
    setShellStyle(SWT.RESIZE | SWT.DIALOG_TRIM);
  }

  protected void configureShell(Shell shell) {
      super.configureShell(shell);
      shell.setText(Messages.getString("MQLQueryBuilderDialog.MQL_QUERY_BUILDER_TITLE")); //$NON-NLS-1$
  }

  protected void createButtonsForButtonBar(Composite parent) {
      createButton(parent, IDialogConstants.OK_ID,
              IDialogConstants.OK_LABEL, true);
      createButton(parent, IDialogConstants.CANCEL_ID,
          IDialogConstants.CANCEL_LABEL, false);
  }

  protected Control createDialogArea(Composite parent) {
      Composite composite = (Composite) super.createDialogArea(parent);      
      
      mqlQueryBuilderComposite = new MQLQueryBuilderComposite(composite, SWT.NONE);
      mqlQueryBuilderComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
      if (mqlQuery != null) {
        mqlQueryBuilderComposite.setMqlQuery(mqlQuery);
      }
      GridData gridData = new GridData(GridData.FILL_BOTH);
      gridData.heightHint = 800;
      gridData.widthHint = 1000;
      composite.setLayoutData(gridData);
      return composite;
  }

  
  public void dispose() {
  }

  protected void okPressed() {
    MQLQuery query = mqlQueryBuilderComposite.getMqlQuery();
    if ((query != null) && (query.getSelections().size() > 0)) {
      mqlQuery = query;
      setReturnCode(OK);
      close();
    }
  }

  public MQLQuery getMqlQuery() {
    return mqlQuery;
  }

}