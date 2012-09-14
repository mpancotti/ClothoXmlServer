/*
 * File: app.js
 *
 * This file was generated by Sencha Architect version 2.1.0.
 * http://www.sencha.com/products/architect/
 *
 * This file requires use of the Ext JS 4.1.x library, under independent license.
 * License of Sencha Architect does not include license for Ext JS 4.1.x. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

Ext.Loader.setConfig({
    enabled: true,
    paths: {
        ClothoExtXml: 'app'
    }
});

Ext.application({
    models: [
        'Discount',
        'Prezzo',
        'PrezzoFisso',
        'Rule',
        'Sconto',
        'Vendor',
        'Strategy'
    ],
    stores: [
        'Discounts',
        'Prezzi',
        'PrezziFissi',
        'Rules',
        'Sconti',
        'Vendors',
        'Strategy'
    ],
    views: [
        'VendorDataPanel',
        'RulesAreaPanel',
        'MainToolbar',
        'VendorArea',
        'VendorForm',
        'VendorGridPaneL',
        'RuleGidPanel',
        'RuleForm',
        'ScontiGridPanel',
        'PrezziGridPanel',
        'PrezziFissiGridPanel',
        'DiscountGridPanel'
    ],
    autoCreateViewport: true,
    name: 'ClothoExtXml',
    controllers: [
        'Rules',
        'Vendors',
        'FocusController',
        'Sconti',
        'Prezzi',
        'Prezzifissi'
    ],

    launch: function() {
        Ext.getCmp('vendorGridPanel').getSelectionModel().select(0);
        Ext.JSON.encodeDate=function(d){
            return Ext.Date.format(d,'"m/d/Y"');
        }
    }

});
