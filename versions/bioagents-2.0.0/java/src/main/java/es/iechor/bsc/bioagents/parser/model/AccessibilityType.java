/**
 * *****************************************************************************
 * Copyright (C) 2017 IECHOR ES, Spanish National Bioinformatics Institute (INB)
 * and Barcelona Supercomputing Center (BSC)
 *
 * Modifications to the initial code base are copyright of their respective
 * authors, or their employers as appropriate.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 *****************************************************************************
 */

package es.iechor.bsc.bioagents.parser.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * @author Dmitry Repchevsky
 */

@XmlEnum(EnumType.class)
public enum AccessibilityType {
    @XmlEnumValue("Open access") OPEN_ACCESS("Open access"),
    @XmlEnumValue("Restricted access") RESTRICTED_ACCESS("Restricted access"),
    @XmlEnumValue("Proprietary") PROPRIETARY("Proprietary"),
    @XmlEnumValue("Freeware") FREEWARE("Freeware");
    
    public final String value;
    
    private AccessibilityType(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static AccessibilityType fromValue(String value) {
        for (AccessibilityType type: AccessibilityType.values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException(value);
    }
}
