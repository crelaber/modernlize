package com.uwen.ur.util.crawer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class Test {

	/*
	 * public static void main(String[] args) { String action =
	 * "/admin/log_list.action"; boolean flag =
	 * action.matches("^/admin/[a-zA-Z_0-9]*.action$");
	 * System.out.println(flag);
	 * 
	 * boolean flag2 = action.matches("^/[a-zA-Z_0-9]*.action$");
	 * System.out.println(flag2);
	 * 
	 * }
	 */


	private String dataSourceFile = "e:\\lucene\\testing\\txt";
	private File indexFile = new File("e:\\lucene\\testing\\luceneIndex");
	private Analyzer analyzer = new SmartChineseAnalyzer(Version.LUCENE_43,
			true);
	private String[] queryString = { "filepath", "content" };

	public void createIndex() throws IOException {
		Directory directory = FSDirectory.open(indexFile);
		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(
				Version.LUCENE_43, analyzer);
		indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
		IndexWriter writer = new IndexWriter(directory, indexWriterConfig);

		File[] files = new File(dataSourceFile).listFiles();
		if (files.length > 0) {
			long time1 = System.currentTimeMillis();
			for (int i = 0; i < files.length; i++) {
				Document document = new Document();
				String content = getTXT(files[i], "GBK");
				document.add(new Field("content", content, Field.Store.YES,
						Field.Index.ANALYZED));
				document.add(new Field("filepath", files[i].getName(),
						Field.Store.YES, Field.Index.ANALYZED));
				writer.addDocument(document);
			}
			long time2 = System.currentTimeMillis();
			System.out.println("创建了" + writer.numDocs() + "索引");
			System.out.println("一共花了" + (time2 - time1) + "时间");
		}
		writer.close();
	}

	public void nocnIndex() throws IOException {
		Directory directory = FSDirectory.open(indexFile);
		Analyzer ana = new StandardAnalyzer(Version.LUCENE_43);
		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(
				Version.LUCENE_43, ana);
		indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
		IndexWriter writer = new IndexWriter(directory, indexWriterConfig);

		File[] files = new File(dataSourceFile).listFiles();
		if (files.length > 0) {
			long time1 = System.currentTimeMillis();
			for (int i = 0; i < files.length; i++) {
				Document document = new Document();
				String content = getTXT(files[i], "GBK");
				document.add(new Field("content", content, Field.Store.YES,
						Field.Index.ANALYZED));
				document.add(new Field("filepath", files[i].getName(),
						Field.Store.YES, Field.Index.ANALYZED));
				writer.addDocument(document);
			}
			long time2 = System.currentTimeMillis();
			System.out.println("创建了" + writer.numDocs() + "索引");
			System.out.println("一共花了" + (time2 - time1) + "时间");
		}
		writer.close();
	}

	public void search() throws IOException {
		IndexReader reader = DirectoryReader.open(FSDirectory.open(indexFile));
		IndexSearcher indexSearcher = new IndexSearcher(reader);
		QueryParser queryParser = new MultiFieldQueryParser(Version.LUCENE_43,
				queryString, analyzer);
		Query query = null;
		try {
			query = queryParser.parse("一");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		TopDocs topDocs = indexSearcher.search(query, 10000);
		System.out.println("一共查到:" + topDocs.totalHits + "记录");
		ScoreDoc[] scoreDoc = topDocs.scoreDocs;

		for (int i = 0; i < scoreDoc.length; i++) {
			int doc = scoreDoc[i].doc;
			System.out.println("内部编号:" + doc);
			Document mydoc = indexSearcher.doc(doc);
			System.out.println("文档路径:" + mydoc.get("filepath"));
		}
	}

	public static String getTXT(File file, String charset) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(file), charset));
		String line = new String();
		String temp = new String();
		while ((line = reader.readLine()) != null) {
			temp += line;
		}
		reader.close();
		return temp;
	}

	public static void main(String[] args) throws IOException {
		Test ls = new Test();
		// ls.createIndex();
		//ls.nocnIndex();
		ls.search();
	}

}
