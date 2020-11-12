package com.self.annotation.importbean.withconfig;

import com.self.annotation.importbean.CImport;
import org.springframework.context.annotation.Import;

@Import(value = {CImport.class})
public class C1config {
}
