/**
 * Copyright 2015 LinkedIn Corp. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
package metadata.etl.security;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;
import metadata.etl.EtlJob;
import wherehows.common.Constant;


public class DatasetConfidentialFieldEtl extends EtlJob {
  @Deprecated
  public DatasetConfidentialFieldEtl(int dbId, long whExecId) {
    super(null, dbId, whExecId);
  }

  public DatasetConfidentialFieldEtl(int dbId, long whExecId, Properties prop) {
    super(null, dbId, whExecId, prop);
  }

  @Override
  public void extract() throws Exception {
    logger.info("Dataset Confidential field extract");
  }

  @Override
  public void transform() throws Exception {
    logger.info("Dataset Confidential field transform");
  }

  @Override
  public void load() throws Exception {
    logger.info("Dataset Confidential field load");
    InputStream inputStream = classLoader.getResourceAsStream("jython/ConfidentialFieldLoad.py");
    interpreter.execfile(inputStream);
    inputStream.close();
    logger.info("Dataset Confidential field load finished");
  }
}
