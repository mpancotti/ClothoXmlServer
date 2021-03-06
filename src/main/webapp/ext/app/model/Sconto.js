/*
 * File: app/model/Sconto.js
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

Ext.define('ClothoExtXml.model.Sconto', {
    extend: 'Ext.data.Model',

    fields: [
        {
            name: 'id',
            type: 'int'
        },
        {
            name: 'codice',
            type: 'int'
        },
        {
            name: 'sconto_fornitore',
            type: 'float'
        },
        {
            name: 'tolleranza',
            type: 'float'
        },
        {
            name: 'prezzo_lordo',
            type: 'float'
        },
        {
            name: 'affiliato',
            type: 'float'
        },
        {
            name: 'affiliato_light',
            type: 'float'
        },
        {
            name: 'somministrato',
            type: 'float'
        },
        {
            name: 'prezzo_affiliato',
            type: 'float'
        },
        {
            name: 'prezzo_affiliato_light',
            type: 'float'
        },
        {
            name: 'prezzo_somministrato',
            type: 'float'
        },
        {
            name: 'scadenza',
            type: 'float'
        }
    ]
});