/*
 * File: app/view/RulesAreaPanel.js
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

Ext.define('ClothoExtXml.view.RulesAreaPanel', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.rulesAreaPanel',

    layout: {
        align: 'stretch',
        type: 'vbox'
    },
    title: 'Regole di sconto e prezzo',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'container',
                    flex: 1,
                    layout: {
                        align: 'stretch',
                        type: 'hbox'
                    },
                    items: [
                        {
                            xtype: 'container',
                            maxWidth: 160,
                            minWidth: 160,
                            width: 160,
                            layout: {
                                align: 'stretch',
                                type: 'hbox'
                            },
                            items: [
                                {
                                    xtype: 'gridpanel',
                                    id: 'ruleGridPanel',
                                    maxWidth: 160,
                                    minWidth: 160,
                                    padding: 2,
                                    width: 160,
                                    title: 'Lista Regole ',
                                    enableColumnHide: false,
                                    enableColumnMove: false,
                                    enableColumnResize: false,
                                    store: 'Rules',
                                    viewConfig: {

                                    },
                                    columns: [
                                        {
                                            xtype: 'gridcolumn',
                                            width: 154,
                                            dataIndex: 'id',
                                            text: 'Regola'
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            xtype: 'container',
                            flex: 1,
                            hidden: false,
                            layout: {
                                align: 'stretch',
                                type: 'vbox'
                            },
                            items: [
                                {
                                    xtype: 'form',
                                    flex: 1,
                                    maxHeight: 220,
                                    minHeight: 220,
                                    padding: 2,
                                    bodyPadding: 5,
                                    title: 'Gestione singola regola',
                                    items: [
                                        {
                                            xtype: 'fieldset',
                                            maxWidth: 300,
                                            minWidth: 300,
                                            padding: 5,
                                            width: 300,
                                            title: 'Dati regola di sconto generica',
                                            items: [
                                                {
                                                    xtype: 'textfield',
                                                    anchor: '100%',
                                                    width: 100,
                                                    fieldLabel: 'Regola',
                                                    labelAlign: 'right'
                                                },
                                                {
                                                    xtype: 'numberfield',
                                                    anchor: '100%',
                                                    fieldLabel: 'Valore',
                                                    labelAlign: 'right',
                                                    hideTrigger: true
                                                },
                                                {
                                                    xtype: 'datefield',
                                                    anchor: '100%',
                                                    fieldLabel: 'Scadenza',
                                                    labelAlign: 'right'
                                                },
                                                {
                                                    xtype: 'combobox',
                                                    anchor: '100%',
                                                    fieldLabel: 'Strategia',
                                                    labelAlign: 'right'
                                                }
                                            ]
                                        }
                                    ],
                                    dockedItems: [
                                        {
                                            xtype: 'toolbar',
                                            dock: 'bottom',
                                            ui: 'footer',
                                            items: [
                                                {
                                                    xtype: 'button',
                                                    text: 'Salva'
                                                },
                                                {
                                                    xtype: 'button',
                                                    text: 'Esci senza salvare'
                                                }
                                            ]
                                        }
                                    ]
                                },
                                {
                                    xtype: 'tabpanel',
                                    flex: 1,
                                    padding: 2,
                                    activeTab: 0,
                                    items: [
                                        {
                                            xtype: 'gridpanel',
                                            padding: 2,
                                            title: 'Sconti',
                                            store: 'Sconti',
                                            viewConfig: {

                                            },
                                            columns: [
                                                {
                                                    xtype: 'numbercolumn',
                                                    dataIndex: 'sconto_fornitore',
                                                    text: 'Sconto_fornitore'
                                                },
                                                {
                                                    xtype: 'numbercolumn',
                                                    dataIndex: 'tolleranza',
                                                    text: 'Tolleranza'
                                                },
                                                {
                                                    xtype: 'numbercolumn',
                                                    dataIndex: 'prezzo_lordo',
                                                    text: 'Prezzo_lordo'
                                                },
                                                {
                                                    xtype: 'numbercolumn',
                                                    dataIndex: 'affiliato',
                                                    text: 'Affiliato'
                                                },
                                                {
                                                    xtype: 'numbercolumn',
                                                    dataIndex: 'affiliato_light',
                                                    text: 'Affiliato_light'
                                                },
                                                {
                                                    xtype: 'numbercolumn',
                                                    dataIndex: 'somministrato',
                                                    text: 'Somministrato'
                                                },
                                                {
                                                    xtype: 'numbercolumn',
                                                    dataIndex: 'prezzo_affiliato',
                                                    text: 'Prezzo_affiliato'
                                                },
                                                {
                                                    xtype: 'numbercolumn',
                                                    dataIndex: 'prezzo_affiliato_light',
                                                    text: 'Prezzo_affiliato_light'
                                                },
                                                {
                                                    xtype: 'numbercolumn',
                                                    dataIndex: 'prezzo_somministrato',
                                                    text: 'Prezzo_somministrato'
                                                },
                                                {
                                                    xtype: 'numbercolumn',
                                                    dataIndex: 'scadenza',
                                                    text: 'Scadenza'
                                                }
                                            ]
                                        },
                                        {
                                            xtype: 'gridpanel',
                                            title: 'Prezzi',
                                            store: 'Prezzi',
                                            viewConfig: {

                                            },
                                            columns: [
                                                {
                                                    xtype: 'numbercolumn',
                                                    dataIndex: 'prezzo_from',
                                                    text: 'Prezzo_from'
                                                },
                                                {
                                                    xtype: 'numbercolumn',
                                                    dataIndex: 'prezzo_to',
                                                    text: 'Prezzo_to'
                                                },
                                                {
                                                    xtype: 'numbercolumn',
                                                    dataIndex: 'netto_lordo',
                                                    text: 'Netto_lordo'
                                                },
                                                {
                                                    xtype: 'numbercolumn',
                                                    dataIndex: 'prezzo_affiliato',
                                                    text: 'Prezzo_affiliato'
                                                },
                                                {
                                                    xtype: 'numbercolumn',
                                                    dataIndex: 'prezzo_affiliato_light',
                                                    text: 'Prezzo_affiliato_light'
                                                },
                                                {
                                                    xtype: 'numbercolumn',
                                                    dataIndex: 'prezzo_somministrato',
                                                    text: 'Prezzo_somministrato'
                                                },
                                                {
                                                    xtype: 'datecolumn',
                                                    dataIndex: 'scadenza',
                                                    text: 'Scadenza'
                                                }
                                            ]
                                        },
                                        {
                                            xtype: 'gridpanel',
                                            title: 'Prezzo fisso',
                                            store: 'PrezziFissi',
                                            viewConfig: {

                                            },
                                            columns: [
                                                {
                                                    xtype: 'numbercolumn',
                                                    dataIndex: 'prezzo_fornitore',
                                                    text: 'Prezzo_fornitore'
                                                },
                                                {
                                                    xtype: 'numbercolumn',
                                                    dataIndex: 'netto_lordo',
                                                    text: 'Netto_lordo'
                                                },
                                                {
                                                    xtype: 'numbercolumn',
                                                    dataIndex: 'affiliato',
                                                    text: 'Affiliato'
                                                },
                                                {
                                                    xtype: 'numbercolumn',
                                                    dataIndex: 'affiliato_light',
                                                    text: 'Affiliato_light'
                                                },
                                                {
                                                    xtype: 'numbercolumn',
                                                    dataIndex: 'somministrato',
                                                    text: 'Somministrato'
                                                },
                                                {
                                                    xtype: 'datecolumn',
                                                    dataIndex: 'scadenza',
                                                    text: 'Scadenza'
                                                }
                                            ]
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }

});