package com.sunpeifu.demo.template;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * mysql 代码生成器
 *
 * @author sunpeifu
 * @since 2020-02-06
 */
public class MysqlCodeGenerator {
	/**
	 * 代码生成的模块名
	 */
	public static String CODE_NAME = "exapi";
	/**
	 * 代码生成的包名
	 */
	public static String PACKAGE_NAME = "com.leyue.admin";
	/**
	 * 后台代码生成地址--java
	 */
	public static String PACKAGE_DIR = "/Users/sunpeifu/leyueHosAdmin";
	/**
	 * 前端代码生成地址--vue
	 */
	//public static String PACKAGE_WEB_DIR = "D://temp//esbubcp//autocode//vue//";
	/**
	 * 需要去掉的表前缀
	 */
	public static String[] TABLE_PREFIX = {"ln_"}; //sys_

	/**
	 * 需要去掉的字段前缀
	 */
	public static String[] FILED_PREFIX = {""};
	/**
	 * 需要生成的表名(两者只能取其一)
	 */
	public static String[] INCLUDE_TABLES = {"ln_treatment_order_operation"};
	/**
	 * 需要排除的表名(两者只能取其一)
	 */
	public static String[] EXCLUDE_TABLES = {};
	/**
	 * 是否包含基础业务字段
	 */
	public static Boolean HAS_SUPER_ENTITY = Boolean.FALSE;
	/**
	 * 基础业务字段
	 */
	public static String[] SUPER_ENTITY_COLUMNS = {"id", "create_time", "create_user", "update_time", "update_user", "status", "is_deleted"};

	/**
	 * RUN THIS
	 */
	public static void main(String[] args) {
		// 代码生成器
		AutoGenerator mpg = new AutoGenerator();

		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		// 直接生成在工程目录中 
		/////String projectPath = System.getProperty("user.dir");
		gc.setServiceName("%sService"); // 去掉接口前面的I
		gc.setOutputDir(PACKAGE_DIR + "/src/main/java");
		gc.setAuthor("sunpeifu");
		gc.setFileOverride(true);
		gc.setOpen(false);
		gc.setBaseResultMap(true);  //通用查询映射结果
		gc.setBaseColumnList(true); //通用查询结果列
		gc.setSwagger2(true);       //是否生成swagger2注解
		mpg.setGlobalConfig(gc);

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setUrl("jdbc:mysql://172.16.0.229:3306/gz_his");
		// dsc.setSchemaName("public");
		dsc.setDriverName("com.mysql.cj.jdbc.Driver");
		dsc.setUsername("root");
		dsc.setPassword("ky123456KY+-)(");
		mpg.setDataSource(dsc);

		// 包配置
		PackageConfig pc = new PackageConfig();
		pc.setModuleName(null);
		pc.setParent(PACKAGE_NAME);
		mpg.setPackageInfo(pc);

		// 自定义配置
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {
				// to do nothing
			}
		};
		List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
		focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				// 自定义输入文件名称，输出至resources目录
				// return projectPath + "/src/main/resources/mapper/" + CODE_NAME
				//		+ "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
				// 自定义输入文件名称，输出至java目录
				return PACKAGE_DIR + "/src/main/java/" + PACKAGE_NAME.replace(".", "/") 
					    + "/mapper/xml/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;			
			}
		});
//		// 生成前端vue页面文件
//		focList.add(new FileOutConfig("/templates/vue/list.vue.ftl") {
//			@Override
//			public String outputFile(TableInfo tableInfo) {
//				// 自定义输入文件名称
//				return PACKAGE_WEB_DIR + CODE_NAME
//						+ "/" + tableInfo.getEntityName() + "List" + ".vue";
//			}
//		});
//		focList.add(new FileOutConfig("/templates/vue/modal.vue.ftl") {
//			@Override
//			public String outputFile(TableInfo tableInfo) {
//				// 自定义输入文件名称
//				return PACKAGE_WEB_DIR + CODE_NAME
//						+ "/" + tableInfo.getEntityName() + "Modal" + ".vue";
//			}
//		});
		
		cfg.setFileOutConfigList(focList);
		mpg.setCfg(cfg);
		mpg.setTemplate(new TemplateConfig().setXml(null));

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setNaming(NamingStrategy.underline_to_camel);
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);
		strategy.setEntityLombokModel(true);
		strategy.setRestControllerStyle(true);


		if (HAS_SUPER_ENTITY) {
			strategy.setSuperControllerClass("com.ebtech.esbubcp.common.system.base.controller.BaseController");
			strategy.setSuperEntityClass("com.ebtech.esbubcp.common.system.base.entity.BaseEntity");
			strategy.setSuperEntityColumns(SUPER_ENTITY_COLUMNS);
			strategy.setSuperServiceClass("com.ebtech.esbubcp.common.system.base.service.BaseService");
			strategy.setSuperServiceImplClass("com.ebtech.esbubcp.common.system.base.service.impl.BaseServiceImpl");
		} else {
			strategy.setSuperServiceClass("com.baomidou.mybatisplus.extension.service.IService");
			strategy.setSuperServiceImplClass("com.baomidou.mybatisplus.extension.service.impl.ServiceImpl");
		}
		
		if (INCLUDE_TABLES.length > 0) {
			strategy.setInclude(INCLUDE_TABLES);
		}
		if (EXCLUDE_TABLES.length > 0) {
			strategy.setExclude(EXCLUDE_TABLES);
		}
		////strategy.setSuperEntityColumns("id");
		strategy.setControllerMappingHyphenStyle(true);
		strategy.setTablePrefix(TABLE_PREFIX);
//		strategy.setFieldPrefix(FILED_PREFIX);
//		strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//		strategy.setNaming(NamingStrategy.underline_to_camel);
		mpg.setStrategy(strategy);
		// 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
		mpg.setTemplateEngine(new FreemarkerTemplateEngine());
		mpg.execute();
	}
}
