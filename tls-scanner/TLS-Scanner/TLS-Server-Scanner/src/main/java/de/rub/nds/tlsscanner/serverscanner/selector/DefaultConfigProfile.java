/**
 * TLS-Server-Scanner - A TLS configuration and analysis tool based on TLS-Attacker
 *
 * Copyright 2017-2023 Ruhr University Bochum, Paderborn University, Hackmanit GmbH
 *
 * Licensed under Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0.txt
 */

package de.rub.nds.tlsscanner.serverscanner.selector;

import de.rub.nds.modifiablevariable.util.ArrayConverter;

public enum DefaultConfigProfile implements ConfigFilterProfile {

    UNFILTERED(),

    SLIGHTLY_REDUCED_CIPHERSUITES(ConfigFilterType.CIPHERSUITE_UNNEGOTIABLE, ConfigFilterType.CIPHERSUITE_UNOFFICIAL,
        ConfigFilterType.CIPHERSUITE_GREASE, ConfigFilterType.CIPHERSUITE_TLS13),
    MODERATELY_REDUCED_CIPHERSUITES(SLIGHTLY_REDUCED_CIPHERSUITES.getConfigFilterTypes(),
        ConfigFilterType.CIPHERSUITE_KRB5, ConfigFilterType.CIPHERSUITE_ECCPWD, ConfigFilterType.CIPHERSUITE_SSL),
    HIGHLY_REDUCED_CIPHERSUITES(MODERATELY_REDUCED_CIPHERSUITES.getConfigFilterTypes(),
        ConfigFilterType.CIPHERSUITE_ANON, ConfigFilterType.CIPHERSUITE_EXPORT, ConfigFilterType.CIPHERSUITE_PSK,
        ConfigFilterType.CIPHERSUITE_SRP, ConfigFilterType.CIPHERSUITE_ARIA, ConfigFilterType.CIPHERSUITE_CAMELLIA),
    EXTREME_REDUCED_CIPHERSUITES(HIGHLY_REDUCED_CIPHERSUITES.getConfigFilterTypes(), ConfigFilterType.CIPHERSUITE_RC4,
        ConfigFilterType.CIPHERSUITE_NULL, ConfigFilterType.CIPHERSUITE_GOST, ConfigFilterType.CIPHERSUITE_CECPQ1,
        ConfigFilterType.CIPHERSUITE_RABBIT),

    SLIGHTLY_REDUCED_NAMEDGROUPS(ConfigFilterType.NAMEDGROUP_GREASE),
    MODERATELY_REDUCED_NAMEDGROUPS(SLIGHTLY_REDUCED_NAMEDGROUPS.getConfigFilterTypes(),
        ConfigFilterType.NAMEDGROUP_SECT),
    HIGHLY_REDUCED_NAMEDGROUPS(MODERATELY_REDUCED_NAMEDGROUPS.getConfigFilterTypes(),
        ConfigFilterType.NAMEDGROUP_BRAINPOOL),
    EXTREME_REDUCED_NAMEDGROUPS(HIGHLY_REDUCED_NAMEDGROUPS.getConfigFilterTypes(),
        ConfigFilterType.NAMEDGROUP_DEPRECATED),

    SLIGHTLY_REDUCED_SIGNATUREALGORITHMS(ConfigFilterType.SIGNATUREALGORITHM_GREASE),
    MODERATELY_REDUCED_SIGNATUREALGORITHMS(SLIGHTLY_REDUCED_SIGNATUREALGORITHMS.getConfigFilterTypes(),
        ConfigFilterType.SIGNATUREALGORITHM_ANON),
    HIGHLY_REDUCED_SIGNATUREALGORITHMS(MODERATELY_REDUCED_SIGNATUREALGORITHMS.getConfigFilterTypes(),
        ConfigFilterType.SIGNATUREALGORITHM_MD5, ConfigFilterType.SIGNATUREALGORITHM_SHA1,
        ConfigFilterType.SIGNATUREALGORITHM_NONE),
    EXTREME_REDUCED_SIGNATUREALGORITHMS(HIGHLY_REDUCED_SIGNATUREALGORITHMS.getConfigFilterTypes(),
        ConfigFilterType.SIGNATUREALGORITHM_GOST, ConfigFilterType.SIGNATUREALGORITHM_DSA),

    SLIGHTLY_REDUCED_COMBINATION(ArrayConverter.concatenate(SLIGHTLY_REDUCED_CIPHERSUITES.getConfigFilterTypes(),
        SLIGHTLY_REDUCED_NAMEDGROUPS.getConfigFilterTypes(),
        SLIGHTLY_REDUCED_SIGNATUREALGORITHMS.getConfigFilterTypes())),
    MODERATELY_REDUCED_COMBINATION(ArrayConverter.concatenate(MODERATELY_REDUCED_CIPHERSUITES.getConfigFilterTypes(),
        MODERATELY_REDUCED_NAMEDGROUPS.getConfigFilterTypes(),
        MODERATELY_REDUCED_SIGNATUREALGORITHMS.getConfigFilterTypes())),
    HIGHLY_REDUCED_COMBINATION((ArrayConverter.concatenate(HIGHLY_REDUCED_CIPHERSUITES.getConfigFilterTypes(),
        HIGHLY_REDUCED_NAMEDGROUPS.getConfigFilterTypes(), HIGHLY_REDUCED_SIGNATUREALGORITHMS.getConfigFilterTypes()))),
    EXTREME_REDUCED_COMBINATION((ArrayConverter.concatenate(EXTREME_REDUCED_CIPHERSUITES.getConfigFilterTypes(),
        EXTREME_REDUCED_NAMEDGROUPS.getConfigFilterTypes(),
        EXTREME_REDUCED_SIGNATUREALGORITHMS.getConfigFilterTypes()))),

    RICH_TLS_13(),
    CLEAN_NAMEDGROUPS_TLS_13(ConfigFilterType.NAMEDGROUP_DEPRECATED),
    CLEAN_SIGNATUREALGORITHMS_TLS_13(ConfigFilterType.SIGNATUREALGORITHM_TLS13),
    CLEAN_TLS_13(ArrayConverter.concatenate(CLEAN_NAMEDGROUPS_TLS_13.getConfigFilterTypes(),
        CLEAN_SIGNATUREALGORITHMS_TLS_13.getConfigFilterTypes()));

    private final ConfigFilterType[] configFilterTypes;

    private DefaultConfigProfile(ConfigFilterType... configFilterTypes) {
        this.configFilterTypes = configFilterTypes;
    }

    private DefaultConfigProfile(ConfigFilterType[] previousFilters, ConfigFilterType... configFilterTypes) {
        this.configFilterTypes = ArrayConverter.concatenate(previousFilters, configFilterTypes);
    }

    @Override
    public ConfigFilterType[] getConfigFilterTypes() {
        return configFilterTypes;
    }

    @Override
    public String getIdentifier() {
        return this.name();
    }

    public static DefaultConfigProfile[] getTls12ConfigProfiles() {
        return new DefaultConfigProfile[] { UNFILTERED, SLIGHTLY_REDUCED_CIPHERSUITES, SLIGHTLY_REDUCED_NAMEDGROUPS,
            SLIGHTLY_REDUCED_SIGNATUREALGORITHMS, SLIGHTLY_REDUCED_COMBINATION, MODERATELY_REDUCED_CIPHERSUITES,
            MODERATELY_REDUCED_NAMEDGROUPS, MODERATELY_REDUCED_SIGNATUREALGORITHMS, MODERATELY_REDUCED_COMBINATION,
            HIGHLY_REDUCED_CIPHERSUITES, HIGHLY_REDUCED_NAMEDGROUPS, HIGHLY_REDUCED_SIGNATUREALGORITHMS,
            HIGHLY_REDUCED_COMBINATION, EXTREME_REDUCED_CIPHERSUITES, EXTREME_REDUCED_NAMEDGROUPS,
            EXTREME_REDUCED_SIGNATUREALGORITHMS, EXTREME_REDUCED_COMBINATION };
    }

    public static DefaultConfigProfile[] getTls13ConfigProfiles() {
        return new DefaultConfigProfile[] { RICH_TLS_13, SLIGHTLY_REDUCED_NAMEDGROUPS, MODERATELY_REDUCED_NAMEDGROUPS,
            CLEAN_NAMEDGROUPS_TLS_13, CLEAN_SIGNATUREALGORITHMS_TLS_13, CLEAN_TLS_13 };
    }

}
