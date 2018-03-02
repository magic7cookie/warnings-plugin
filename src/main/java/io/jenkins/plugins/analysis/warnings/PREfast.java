package io.jenkins.plugins.analysis.warnings;

import javax.annotation.Nonnull;

import org.kohsuke.stapler.DataBoundConstructor;

import io.jenkins.plugins.analysis.core.model.StaticAnalysisTool;

import hudson.Extension;

import edu.hm.hafner.analysis.parser.PreFastParser;

/**
 * Provides a parser and customized messages for Microsoft PREfast.
 *
 * @author Ullrich Hafner
 */
public class PREfast extends StaticAnalysisTool {
    static final String ID = "pre-fast";

    /** Creates a new instance of {@link PREfast}. */
    @DataBoundConstructor
    public PREfast() {
        // empty constructor required for stapler
    }

    @Override
    public PreFastParser createParser() {
        return new PreFastParser();
    }

    /** Descriptor for this static analysis tool. */
    @Extension
    public static class Descriptor extends StaticAnalysisToolDescriptor {
        public Descriptor() {
            super(ID);
        }

        @Nonnull
        @Override
        public String getDisplayName() {
            return Messages.Warnings_PREfast_ParserName();
        }
    }
}
